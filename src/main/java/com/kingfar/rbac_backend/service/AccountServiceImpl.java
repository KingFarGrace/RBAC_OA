package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.InfoOptResp;
import com.kingfar.rbac_backend.dto.RegisterResp;
import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.dto.UserInfoResp;
import com.kingfar.rbac_backend.mapper.InfoOperateMapper;
import com.kingfar.rbac_backend.mapper.LoginMapper;
import com.kingfar.rbac_backend.mapper.RegisterMapper;
import com.kingfar.rbac_backend.pojo.*;
import com.kingfar.rbac_backend.utils.RandomCodeUtil;
import com.kingfar.rbac_backend.vo.AccountInfoOptForm;
import com.kingfar.rbac_backend.pojo.PersonalInfo;
import com.kingfar.rbac_backend.vo.UserAuthenticationForm;
import com.kingfar.rbac_backend.vo.UserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ZKH
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final String LOGIN_BY_UID = "^\\d{12}$";
    private static final String LOGIN_BY_USERNAME = "^[\\u4E00-\\u9FA5a-zA-Z][\\u4E00-\\u9FA5A-Za-z0-9_]{1,16}$";
    private static final String LOGIN_BY_TELEPHONE = "^\\d{11}$";
    private static final String LOGIN_BY_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    private static final String UPDATE_COLUMN_USERNAME = "username";
    private static final String UPDATE_COLUMN_PASSWORD = "password";
    private static final String UPDATE_COLUMN_TELENUM = "telenum";
    private static final String UPDATE_COLUMN_EMAIL = "email";

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RegisterMapper registerMapper;

    @Autowired
    private InfoOperateMapper infoOperateMapper;

    @Override
    public UserBasicInfo queryBasicInfo(String key) {
        UserBasicInfo userBasicInfo = null;
        try {
            if (Pattern.matches(LOGIN_BY_UID, key)) {
                System.out.println("login by uid.");
                userBasicInfo = loginMapper.queryUserBasicInfoByUid(key);
            }
            if (Pattern.matches(LOGIN_BY_USERNAME, key)) {
                System.out.println("login by username.");
                userBasicInfo = loginMapper.queryUserBasicInfoByUsername(key);
            }
            if (Pattern.matches(LOGIN_BY_TELEPHONE, key)) {
                System.out.println("login by telephone number.");
                userBasicInfo = loginMapper.queryUserBasicInfoByTelenum(key);
            }
            if (Pattern.matches(LOGIN_BY_EMAIL, key)) {
                System.out.println("login by email.");
                userBasicInfo = loginMapper.queryUserBasicInfoByEmail(key);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userBasicInfo;
    }

    @Override
    public boolean verify(String pwd, String toVerify) {
        //TODO encrypt
        return pwd.equals(toVerify);
    }

    @Override
    public UserInfoResp queryFullInfo(UserBasicInfo basicInfo) {
        String uid = basicInfo.getUid();
        List<GroupInfo> groupInfo = loginMapper.queryGroupInfoByUid(uid);
        List<DepartInfo> departInfo = loginMapper.queryDepartInfoByUid(uid);
        List<RoleInfo> roleInfo = loginMapper.queryRoleInfoByUid(uid);
        List<PermInfo> permInfo = loginMapper.queryPermInfoByUid(uid);
        List<String> groups = new ArrayList<>();
        List<String> departs = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        List<String> permCodes = new ArrayList<>();
        if (groupInfo != null) {
            for (GroupInfo info : groupInfo) {
                groups.add(info.getGname());
            }
        }
        if (departInfo != null) {
            for (DepartInfo info : departInfo) {
                departs.add(info.getDname());
            }
        }
        if (roleInfo != null) {
            for (RoleInfo info : roleInfo) {
                roles.add(info.getRname());
            }
        }
        if (permInfo != null) {
            for (PermInfo info : permInfo) {
                permCodes.add(info.getPcode());
            }
        }

        return new UserInfoResp
                (
                        0,
                        "success",
                        basicInfo,
                        groups,
                        departs,
                        roles,
                        permCodes
                );
    }

    @Override
    public Response login(UserAuthenticationForm form) {
        UserBasicInfo basicInfo = null;
        try {
            basicInfo = queryBasicInfo(form.getKey());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new UserInfoResp(
                    4, "server error, please try later.",
                    null,
                    null,
                    null,
                    null,
                    null);
        }

        if (basicInfo == null) {
            return new UserInfoResp(
                    1, String.format("no such user(account id: %s)", form.getKey()),
                    null,
                    null,
                    null,
                    null,
                    null);
        }
        //TODO decryption: after frontend encryption module has been done
        if (!verify(basicInfo.getPassword(), form.getPassword())) {
            return new UserInfoResp(
                    2, "wrong password",
                    null,
                    null,
                    null,
                    null,
                    null);
        }

        UserInfoResp successResp = null;
        try {
            successResp = queryFullInfo(basicInfo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new UserInfoResp(
                    4, "server error, please try later.",
                    null,
                    null,
                    null,
                    null,
                    null);
        }
        return successResp;
    }

    @Override
    public Response register(UserRegisterForm form) {
        try {
            String uid = RandomCodeUtil.generateRandomUID(12);
            while (registerMapper.countUserByUid(uid) != 0) {
                uid = RandomCodeUtil.generateRandomUID(12);
            }
            if (registerMapper.countUserByUsername(form.getUsername()) != 0) {
                return new RegisterResp(3, String
                        .format("username has been occupied(%s), please change it.", form.getUsername()));
            }
            registerMapper
                    .setNewUserInfo(
                            uid,
                            form.getUsername(),
                            form.getPassword(),
                            form.getRealname(),
                            new Date(System.currentTimeMillis())
                    );
        } catch (DuplicateKeyException duplicateKeyException) {
            System.out.println(duplicateKeyException.getMessage());
            return new RegisterResp(4, "server error, please try later.");
        }
        return new RegisterResp(0, "success");
    }

    @Override
    public Response updateUsername(String uid, String newUsername) {
        if (registerMapper.countUserByUsername(newUsername) > 0) {
            return new InfoOptResp(3, String
                    .format("username(%s) has been used, please change.", newUsername));
        }
        if (infoOperateMapper.updateUsername(uid, newUsername)) {
            return new InfoOptResp(0, "success to update username");
        } else {
            return new InfoOptResp(1, "failed to update user info(no such user)");
        }
    }

    @Override
    public Response updatePassword(String uid, String newPassword) {
        // TODO decrypt and encrypt
        if (infoOperateMapper.updatePassword(uid, newPassword)) {
            return new InfoOptResp(0, "success to update Password");
        } else {
            return new InfoOptResp(1, "failed to update user info(no such user)");
        }
    }

    @Override
    public Response updateTelenum(String uid, String newTelenum) {
        if (infoOperateMapper.countUserNumberByTelenum(newTelenum) > 0) {
            return new InfoOptResp(3, String
                    .format("telephone number(%s) has been used, please change.", newTelenum));
        }
        if (infoOperateMapper.updateTelenum(uid, newTelenum)) {
            return new InfoOptResp(0, "success to update telephone number");
        } else {
            return new InfoOptResp(1, "failed to update user info(no such user)");
        }
    }

    @Override
    public Response updateEmail(String uid, String newEmail) {
        if (infoOperateMapper.countUserNumberByEmail(newEmail) > 0) {
            return new InfoOptResp(3, String
                    .format("email address(%s) has been used, please change.", newEmail));
        }
        if (infoOperateMapper.updateEmail(uid, newEmail)) {
            return new InfoOptResp(0, "success to update email address");
        } else {
            return new InfoOptResp(1, "failed to update user info(no such user)");
        }
    }

    @Override
    public Response updateAccountInfo(AccountInfoOptForm form) {
        try {
            if (UPDATE_COLUMN_USERNAME.equals(form.getWhichToUpdate())) {
                System.out.println("update:" + UPDATE_COLUMN_USERNAME);
                return updateUsername(form.getUid(), form.getNewAccountInfo());
            } else if (UPDATE_COLUMN_PASSWORD.equals(form.getWhichToUpdate())) {
                System.out.println("update:" + UPDATE_COLUMN_PASSWORD);
                return updatePassword(form.getUid(), form.getNewAccountInfo());
            } else if (UPDATE_COLUMN_TELENUM.equals(form.getWhichToUpdate())) {
                System.out.println("update:" + UPDATE_COLUMN_TELENUM);
                return updateTelenum(form.getUid(), form.getNewAccountInfo());
            } else if (UPDATE_COLUMN_EMAIL.equals(form.getWhichToUpdate())) {
                System.out.println("update:" + UPDATE_COLUMN_EMAIL);
                return updateEmail(form.getUid(), form.getNewAccountInfo());
            } else {
                return new InfoOptResp(2, String
                        .format("reject by server:　unauthorized update request(%s)", form.getWhichToUpdate()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new InfoOptResp(4, "server error, please try later");
        }
    }

    @Override
    public Response batchPersonalInfosEntry(List<PersonalInfo> infos) {
        boolean isAllQueryDone = true;
        StringBuilder errorUids = new StringBuilder();
        for (PersonalInfo info : infos) {
            String uid = info.getUid();
            String realname = info.getRealname();
            int age = info.getAge();
            String gender = info.getGender();
            try {
                if (
                        !infoOperateMapper.updateRealname(uid, realname) ||
                        !infoOperateMapper.updateAge(uid, age) ||
                        !infoOperateMapper.updateGender(uid, gender)
                ) {
                    isAllQueryDone = false;
                    errorUids.append(uid).append(", ");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                isAllQueryDone = false;
                errorUids.append(uid).append(", ");
            }
        }
        if (isAllQueryDone) {
            return new InfoOptResp(0, "success");
        } else {
            return new InfoOptResp(5, String
                    .format("batch entry process didn't finish all queries, there are several errors happened when update information of (%s), please check if these UIDs are correct."
                            , errorUids.toString()));
        }
    }

}

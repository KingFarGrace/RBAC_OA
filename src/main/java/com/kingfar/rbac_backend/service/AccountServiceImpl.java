package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.RegisterResp;
import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.dto.UserInfoResp;
import com.kingfar.rbac_backend.mapper.LoginMapper;
import com.kingfar.rbac_backend.mapper.RegisterMapper;
import com.kingfar.rbac_backend.pojo.*;
import com.kingfar.rbac_backend.utils.RandomCodeUtil;
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

    private static final String loginByUid = "^\\d{12}$";
    private static final String loginByUsername = "^[\\u4E00-\\u9FA5a-zA-Z][\\u4E00-\\u9FA5A-Za-z0-9_]{1,16}$";
    private static final String loginByTelenum = "^\\d{11}$";
    private static final String loginByEmail = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public UserBasicInfo queryBasicInfo(String key) {
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        if (Pattern.matches(loginByUid, key)) {
            System.out.println("login by uid.");
            userBasicInfo = loginMapper.queryUserBasicInfoByUid(key);
        }
        if (Pattern.matches(loginByUsername, key)) {
            System.out.println("login by username.");
            userBasicInfo = loginMapper.queryUserBasicInfoByUsername(key);
        }
        if (Pattern.matches(loginByTelenum, key)) {
            System.out.println("login by telephone number.");
            userBasicInfo = loginMapper.queryUserBasicInfoByTelenum(key);
        }
        if (Pattern.matches(loginByEmail, key)) {
            System.out.println("login by email.");
            userBasicInfo = loginMapper.queryUserBasicInfoByEmail(key);
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
        String uid = RandomCodeUtil.generateRandomUID(12);
        //TODO check duplication on key 'uid' first, which means new mapper interfaces
        while (registerMapper.countUserByUid(uid) != 0) {
            uid = RandomCodeUtil.generateRandomUID(12);
        }
        if (registerMapper.countUserByUsername(form.getUsername()) != 0) {
            return new RegisterResp(3, String.format("username has been occupied(%s), please change it.", form.getUsername()));
        }
        try {
            registerMapper.setNewUserInfo(uid, form.getUsername(), form.getPassword(), form.getRealname(), new Date(System.currentTimeMillis()));
        } catch (DuplicateKeyException duplicateKeyException) {
            System.out.println(duplicateKeyException.getMessage());
            return new RegisterResp(4, "server error, please try later.");
        }
        return new RegisterResp(0, "success");
    }

}

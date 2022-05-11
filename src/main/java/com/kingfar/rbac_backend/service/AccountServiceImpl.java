package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.UserInfoResp;
import com.kingfar.rbac_backend.mapper.LoginMapper;
import com.kingfar.rbac_backend.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        for (GroupInfo info : groupInfo) {
            groups.add(info.getGname());
        }
        for (DepartInfo info : departInfo) {
            departs.add(info.getDname());
        }
        for (RoleInfo info : roleInfo) {
            roles.add(info.getRname());
        }
        for (PermInfo info : permInfo) {
            permCodes.add(info.getPcode());
        }
        return new UserInfoResp
                (
                        uid,
                        basicInfo.getUsername(),
                        basicInfo.getRealname(),
                        basicInfo.getGender(),
                        basicInfo.getTelenum(),
                        basicInfo.getEmail(),
                        groups,
                        departs,
                        roles,
                        permCodes
                );
    }

}

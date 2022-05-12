package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.RegisterResp;
import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.dto.UserInfoResp;
import com.kingfar.rbac_backend.pojo.UserBasicInfo;
import com.kingfar.rbac_backend.vo.UserAuthenticationForm;
import com.kingfar.rbac_backend.vo.UserRegisterForm;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * @author ZKH
 */
public interface AccountService {

    UserBasicInfo queryBasicInfo(String key);

    boolean verify(String password, String toVerify);

    UserInfoResp queryFullInfo(UserBasicInfo basicInfo);

    Response login(UserAuthenticationForm form);

    Response register(UserRegisterForm form);

}

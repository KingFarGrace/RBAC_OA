package com.kingfar.rbac_backend.controller;

import com.kingfar.rbac_backend.dto.UserInfoResp;
import com.kingfar.rbac_backend.pojo.UserBasicInfo;
import com.kingfar.rbac_backend.service.AccountService;
import com.kingfar.rbac_backend.vo.UserAuthenticationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * @author ZKH
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    UserInfoResp login(@RequestBody UserAuthenticationForm form) {
        UserBasicInfo basicInfo = null;
        UserInfoResp resp = null;
        try {
            basicInfo = accountService.queryBasicInfo(form.getKey());
            if (accountService.verify
                    (form.getPassword(), basicInfo.getPassword())) {
                resp = accountService.queryFullInfo(basicInfo);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return resp;
    }

}

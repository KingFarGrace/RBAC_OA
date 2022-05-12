package com.kingfar.rbac_backend.controller;

import com.kingfar.rbac_backend.dto.RegisterResp;
import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.dto.UserInfoResp;
import com.kingfar.rbac_backend.pojo.UserBasicInfo;
import com.kingfar.rbac_backend.service.AccountService;
import com.kingfar.rbac_backend.vo.UserAuthenticationForm;
import com.kingfar.rbac_backend.vo.UserRegisterForm;
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
    Response login(@RequestBody UserAuthenticationForm form) {
        return accountService.login(form);
    }

    @PostMapping("/register")
    Response register(@RequestBody UserRegisterForm form) {
        return accountService.register(form);
    }

}

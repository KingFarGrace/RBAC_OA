package com.kingfar.rbac_backend.controller;

import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.pojo.PersonalInfo;
import com.kingfar.rbac_backend.service.AccountService;
import com.kingfar.rbac_backend.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/update/username")
    Response updateUsername(@RequestBody AccountInfoOptForm form) {
        return accountService.updateAccountInfo(form);
    }

    @PostMapping("/update/entryInfos")
    Response entryPersonalInfos(@RequestBody PersonalInfosEntryForm form) {
            return accountService.batchPersonalInfosEntry(form.getInfos());
    }

}

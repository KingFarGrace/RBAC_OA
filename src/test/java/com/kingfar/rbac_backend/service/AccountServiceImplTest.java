package com.kingfar.rbac_backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    AccountService accountService;

    @Test
    void testLoginByUid() {
        System.out.println(accountService.queryBasicInfo("12018108062"));
    }

    @Test
    void testLoginByUsername() {
        System.out.println(accountService.queryBasicInfo("kingfar"));
    }

    @Test
    void testLoginByTelenum() {
        System.out.println(accountService.queryBasicInfo("15611311841"));
    }

    @Test
    void testLoginByEmail() {
        System.out.println(accountService.queryBasicInfo("1136421682@qq.com"));
    }

    @Test
    void testVerify() {
        assert accountService.verify("132546", "132546");
        assert !accountService.verify("132546", "133333");
    }

    @Test
    void testQueryAllInfo() {
        System.out.println(accountService.queryFullInfo(accountService.queryBasicInfo("120181080602")));
    }

}
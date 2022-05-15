package com.kingfar.rbac_backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobArrangementServiceImplTest {

    @Autowired
    JobArrangementService jobArrangementService;

    @Test
    void queryGroupInfo() {
        System.out.println(jobArrangementService.queryGroupInfo("后台管理系统研究小组"));
        System.out.println(jobArrangementService.queryGroupInfo("不存在的小组"));
    }
}
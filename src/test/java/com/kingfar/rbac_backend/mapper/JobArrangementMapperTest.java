package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.utils.RandomCodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobArrangementMapperTest {

    @Autowired
    JobArrangementMapper jobArrangementMapper;

    @Test
    void setNewGroup() {
        System.out.println(jobArrangementMapper.setNewGroup("人工智能研究小组", RandomCodeUtil.generateRandomCode(8)));
    }

    @Test
    void setNewDepartment() {
        System.out.println(jobArrangementMapper.setNewDepartment("财务部", RandomCodeUtil.generateRandomCode(8)));
    }

    @Test
    void setNewRole() {
    }

    @Test
    void queryGroupDetailInfo() {
        System.out.println(jobArrangementMapper.queryGroupDetailInfo("后台管理系统研究小组"));
    }

    @Test
    void queryDepartDetailInfo() {
        System.out.println(jobArrangementMapper.queryDepartDetailInfo("财务部"));
    }
}
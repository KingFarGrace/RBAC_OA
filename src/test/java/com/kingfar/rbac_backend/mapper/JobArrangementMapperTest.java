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
        System.out.println(jobArrangementMapper.setNewGroup("人工智能研究组", RandomCodeUtil.generateRandomCode(8)));
    }

    @Test
    void setNewDepartment() {
    }

    @Test
    void setNewRole() {
    }

    @Test
    void queryGroupDetailInfo() {
        System.out.println(jobArrangementMapper.queryGroupDetailInfo("后台管理系统研究小组"));
    }
}
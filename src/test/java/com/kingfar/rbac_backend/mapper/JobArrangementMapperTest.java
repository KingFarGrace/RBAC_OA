package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.utils.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobArrangementMapperTest {

    @Autowired
    JobArrangementMapper jobArrangementMapper;

    @Test
    void setNewGroup() {
        System.out.println(jobArrangementMapper.setNewGroup("人工智能研究小组", RandomUtil.generateRandomCode(8)));
    }

    @Test
    void setNewDepartment() {
        System.out.println(jobArrangementMapper.setNewDepartment("财务部", RandomUtil.generateRandomCode(8)));
    }

    @Test
    void setNewRole() {
    }

    @Test
    void queryGroupDetailInfo() {
        System.out.println(jobArrangementMapper.queryGroupDetailInfo("前端技术研究小组"));
    }

    @Test
    void queryDepartDetailInfo() {
        System.out.println(jobArrangementMapper.queryDepartDetailInfo("财务部"));
    }

    @Test
    void setUserInGroup() {
        System.out.println(jobArrangementMapper.setUserInGroup("120181080702", "前端技术研究小组", false));
    }

    @Test
    void setUserInDepartment() {
        System.out.println(jobArrangementMapper.setUserInDepartment("120181080702", "网络部", false));
    }

    @Test
    void setUserInRole() {
        System.out.println(jobArrangementMapper.setUserInRole("120181080702", "普通员工"));
    }

}
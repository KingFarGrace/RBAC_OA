package com.kingfar.rbac_backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginMapperTest {

    @Autowired
    LoginMapper loginMapper;

    @Test
    void testQueryByUid() {
        System.out.println(loginMapper.queryUserBasicInfoByUid("120181080602").getUid());
    }

    @Test
    void testQueryByUsername() {
        System.out.println(loginMapper.queryUserBasicInfoByUsername("kingfar").getUid());
    }

    @Test
    void testQueryByTelenum() {
        System.out.println(loginMapper.queryUserBasicInfoByTelenum("15611311841").getUid());
    }

    @Test
    void testQueryByEmail() {
        System.out.println(loginMapper.queryUserBasicInfoByEmail("1136421682@qq.com").getUid());
    }

    @Test
    void testQueryDepartment() {
        System.out.println(loginMapper.queryDepartInfoByUid("120181080602"));
    }

    @Test
    void testQueryGroup() {
        System.out.println(loginMapper.queryGroupInfoByUid("120181080602"));
    }

    @Test
    void testQueryPerm() {
        System.out.println(loginMapper.queryPermInfoByUid("120181080602"));
    }

    @Test
    void testQueryRole() {
        System.out.println(loginMapper.queryRoleInfoByUid("120181080602"));
    }

}
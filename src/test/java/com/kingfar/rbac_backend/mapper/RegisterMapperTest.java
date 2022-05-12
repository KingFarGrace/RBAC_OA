package com.kingfar.rbac_backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegisterMapperTest {

    @Autowired
    RegisterMapper registerMapper;

    @Test
    void testSetNewUserInfo() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        assert registerMapper.setNewUserInfo("120181080702", "shaaaa", "shapier", "王亿成", new Date(System.currentTimeMillis()));
    }

    @Test
    void testCount() {
        assert registerMapper.countUserByUid("120181080602") >= 1;
        assert registerMapper.countUserByUid("120181080808") == 0;
        assert registerMapper.countUserByUsername("kingfar") >= 1;
        assert registerMapper.countUserByUsername("zhangsan") == 0;
    }

}
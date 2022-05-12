package com.kingfar.rbac_backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InfoOperateMapperTest {

    @Autowired
    InfoOperateMapper infoOperateMapper;

    @Test
    void updateUsername() {
        assert infoOperateMapper.updateUsername("120181080602", "kingfargrace");
//        assert infoOperateMapper.updateUsername("120181080702", "kingfargrace");
    }

    @Test
    void updateTelenum() {
        assert infoOperateMapper.updateTelenum("120181080702", "15611312204");
    }

    @Test
    void updateEmail() {
        assert infoOperateMapper.updateEmail("120181080602", "kingfargrace@163.com");
    }

    @Test
    void updateRealname() {
        assert infoOperateMapper.updateRealname("366270788746", "张小二");
    }

    @Test
    void updateAge() {
        assert infoOperateMapper.updateAge("366270788746", 26);
    }

    @Test
    void updateGender() {
        assert infoOperateMapper.updateGender("366270788746", "男");
    }

    @Test
    void countUserNumberByTelenum() {
        assert infoOperateMapper.countUserNumberByTelenum("15611311841") > 0;
        assert infoOperateMapper.countUserNumberByTelenum("15611311282") == 0;
    }

    @Test
    void countUserNumberByEmail() {
        assert infoOperateMapper.countUserNumberByEmail("1136421682@qq.com") > 0;
        assert infoOperateMapper.countUserNumberByEmail("1213763744@qq.com") == 0;
    }
}
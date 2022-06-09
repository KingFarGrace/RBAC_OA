package com.kingfar.rbac_backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {

    @Autowired
    MessageMapper messageMapper;

    private final String adminId = "000000000000";

    @Test
    void setGroupMessage() {
        messageMapper.setGroupMessage("后台管理系统研究小组", "120181080602", "大家好啊", true);
    }

    @Test
    void setDepartMessage() {
        messageMapper.setDepartMessage("系统占位", adminId, "后台管理系统的第一条公告", false);
    }

    @Test
    void querySystemAnnouncement() {
        System.out.println(messageMapper.querySystemAnnouncement());
    }

    @Test
    void queryDepartAnnouncement() {
        System.out.println(messageMapper.queryDepartAnnouncement("计算机教研部"));
    }

    @Test
    void queryDepartMessage() {
        System.out.println(messageMapper.queryDepartMessage("计算机教研部", "120181080602"));
    }

    @Test
    void queryGroupAnnouncement() {
        System.out.println(messageMapper.queryGroupAnnouncement("后台管理系统研究小组"));
    }

    @Test
    void queryGroupMessage() {
        System.out.println(messageMapper.queryGroupMessage("后台管理系统研究小组", "120181080602"));
    }
}
package com.kingfar.rbac_backend.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RandomCodeUtilTest {

    @Test
    void testGenerateCode() {
        assert RandomCodeUtil.generateRandomCode(8).length() == 8;
        System.out.println(RandomCodeUtil.generateRandomCode(8));
        System.out.println(RandomCodeUtil.generateRandomCode(8));
        System.out.println(RandomCodeUtil.generateRandomCode(8));
    }

}
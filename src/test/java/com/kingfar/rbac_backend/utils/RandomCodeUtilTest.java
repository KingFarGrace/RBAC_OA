package com.kingfar.rbac_backend.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RandomCodeUtilTest {

    @Test
    void testGenerateCode() {
        assert RandomUtil.generateRandomCode(8).length() == 8;
        System.out.println(RandomUtil.generateRandomCode(8));
        System.out.println(RandomUtil.generateRandomCode(8));
        System.out.println(RandomUtil.generateRandomCode(8));
    }

}
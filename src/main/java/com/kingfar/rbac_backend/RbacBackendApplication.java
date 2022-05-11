package com.kingfar.rbac_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZKH
 */
@SpringBootApplication
@MapperScan("com.kingfar.rbac_backend.mapper")
public class RbacBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacBackendApplication.class, args);
    }

}

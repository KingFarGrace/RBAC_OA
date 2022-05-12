package com.kingfar.rbac_backend.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ZKH
 */
@Data
public class UserBasicInfo {

    private String uid;
    private String username;
    private String password;
    private String realname;
    private int age;
    private String gender;
    private String telenum;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;

}

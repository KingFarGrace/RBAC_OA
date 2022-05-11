package com.kingfar.rbac_backend.pojo;

import lombok.Data;

/**
 * @author ZKH
 */
@Data
public class UserBasicInfo {

    private String uid;
    private String username;
    private String password;
    private String realname;
    private String gender;
    private String telenum;
    private String email;

}

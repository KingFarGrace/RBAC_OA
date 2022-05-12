package com.kingfar.rbac_backend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZKH
 */
@Data
@AllArgsConstructor
public class UserRegisterForm {

    private String username;
    private String password;
    private String realname;

}

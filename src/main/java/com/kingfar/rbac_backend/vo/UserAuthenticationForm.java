package com.kingfar.rbac_backend.vo;

import lombok.Data;

/**
 * @author ZKH
 */
@Data
public class UserAuthenticationForm {

    private String key;
    private String method;
    private String password;

}

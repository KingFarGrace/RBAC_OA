package com.kingfar.rbac_backend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZKH
 */
@Data
@AllArgsConstructor
public class UserAuthenticationForm {

    private String key;
    private String password;

}

package com.kingfar.rbac_backend.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class UserAuthenticationForm extends Form {

    private final String key;
    private final String password;

    public UserAuthenticationForm(String uid, List<String> permCodes, String key, String password) {
        super(uid, permCodes);
        this.key = key;
        this.password = password;
    }
}

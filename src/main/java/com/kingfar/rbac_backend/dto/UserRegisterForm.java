package com.kingfar.rbac_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class UserRegisterForm extends Form {

    private final String username;
    private final String password;
    private final String realname;

    public UserRegisterForm(String uid, List<String> permCodes, String username, String password, String realname) {
        super(uid, permCodes);
        this.username = username;
        this.password = password;
        this.realname = realname;
    }
}

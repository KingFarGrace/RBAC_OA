package com.kingfar.rbac_backend.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class AccountInfoOptForm extends Form {

    private final String whichToUpdate;
    private final String newAccountInfo;

    public AccountInfoOptForm(String uid, List<String> permCodes, String whichToUpdate, String newAccountInfo) {
        super(uid, permCodes);
        this.whichToUpdate = whichToUpdate;
        this.newAccountInfo = newAccountInfo;
    }
}

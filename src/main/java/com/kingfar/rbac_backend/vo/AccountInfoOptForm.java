package com.kingfar.rbac_backend.vo;

import lombok.Data;

/**
 * @author ZKH
 */
@Data
public class AccountInfoOptForm {

    private String uid;
    private String whichToUpdate;
    private String newAccountInfo;

}

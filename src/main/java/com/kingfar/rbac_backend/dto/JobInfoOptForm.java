package com.kingfar.rbac_backend.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class JobInfoOptForm extends Form {

    private final String whichAttrToOpt;
    private final String attrName;

    public JobInfoOptForm(String uid, List<String> permCodes, String whichAttrToOpt, String attrName) {
        super(uid, permCodes);
        this.whichAttrToOpt = whichAttrToOpt;
        this.attrName = attrName;
    }
}

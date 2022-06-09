package com.kingfar.rbac_backend.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class MessageQueryForm extends Form {

    private final String fieldToQuery;
    private final String fieldName;

    public MessageQueryForm(String uid, List<String> permCodes, String fieldToQuery, String fieldName) {
        super(uid, permCodes);
        this.fieldToQuery = fieldToQuery;
        this.fieldName = fieldName;
    }

}

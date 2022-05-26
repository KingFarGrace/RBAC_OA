package com.kingfar.rbac_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author ZKH
 */
@Data
@AllArgsConstructor
public class Form {

    private String uid;
    private List<String> permCodes;

}

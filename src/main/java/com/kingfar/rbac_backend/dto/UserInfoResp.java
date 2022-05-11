package com.kingfar.rbac_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author ZKH
 */
@Data
@AllArgsConstructor
public class UserInfoResp {

    private String uid;
    private String username;
    private String realname;
    private String gender;
    private String telenum;
    private String email;

    private List<String> groups;
    private List<String> departs;
    private List<String> roles;

    private List<String> permCodes;

}

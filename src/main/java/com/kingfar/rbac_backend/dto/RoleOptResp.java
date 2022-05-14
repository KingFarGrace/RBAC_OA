package com.kingfar.rbac_backend.dto;

import lombok.Getter;

/**
 * @author ZKH
 */
@Getter
public class RoleOptResp extends Response {

    public RoleOptResp(int code, String msg) {
        super(code, msg);
    }

    @Override
    protected int groupCode() {
        return 3;
    }

}

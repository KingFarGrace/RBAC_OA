package com.kingfar.rbac_backend.dto;

import lombok.Getter;

/**
 * @author ZKH
 */
@Getter
public class RegisterResp extends Response {

    private final String uid;

    public RegisterResp(int code, String msg, String uid) {
        super(code, msg);
        this.uid = uid;
    }

    @Override
    protected int groupCode() {
        return 1;
    }

}

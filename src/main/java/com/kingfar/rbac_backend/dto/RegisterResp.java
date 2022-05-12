package com.kingfar.rbac_backend.dto;

/**
 * @author ZKH
 */
public class RegisterResp extends Response {

    public RegisterResp(int code, String msg) {
        super(code, msg);
    }

    @Override
    protected int groupCode() {
        return 1;
    }

}

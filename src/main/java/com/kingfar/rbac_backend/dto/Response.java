package com.kingfar.rbac_backend.dto;

import lombok.Data;

/**
 * @author ZKH
 */
@Data
public abstract class Response {
    private int code;
    private String msg;

    public Response(int code, String msg) {
        this.code = code + groupCode() * groupCodeMultiplier();
        this.msg = msg;
    }

    /**
     * group code to classify different types of return code
     * @return
     */
    protected abstract int groupCode();

    protected int groupCodeMultiplier() {
        return 100;
    }
}

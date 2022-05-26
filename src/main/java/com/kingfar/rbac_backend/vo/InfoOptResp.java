package com.kingfar.rbac_backend.vo;

/**
 * @author ZKH
 */
public class InfoOptResp extends Response {

    public InfoOptResp(int code, String msg) {
        super(code, msg);
    }

    @Override
    protected int groupCode() {
        return 2;
    }

}

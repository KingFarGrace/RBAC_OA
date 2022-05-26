package com.kingfar.rbac_backend.vo;

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
     * group code vo classify different types of return code
     * @return group code which distinguish the type of response
     * group code = 1 - login/register response
     *              2 - data update response
     *              3 - group/department/role operation response
     *              4 - authorization/authentication response
     *              5 - message response
     */
    protected abstract int groupCode();

    protected int groupCodeMultiplier() {
        return 100;
    }
}

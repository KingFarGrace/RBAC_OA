package com.kingfar.rbac_backend.vo;

import com.kingfar.rbac_backend.pojo.DepartDetailInfo;
import lombok.Getter;

/**
 * @author ZKH
 */
@Getter
public class DepartOptResp extends Response {

    private final DepartDetailInfo departDetailInfo;

    public DepartOptResp(int code, String msg, DepartDetailInfo departDetailInfo) {
        super(code, msg);
        this.departDetailInfo = departDetailInfo;
    }

    @Override
    protected int groupCode() {
        return 3;
    }

}

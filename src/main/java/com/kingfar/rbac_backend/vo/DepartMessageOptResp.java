package com.kingfar.rbac_backend.vo;

import com.kingfar.rbac_backend.pojo.DepartMessage;
import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class DepartMessageOptResp extends Response {

    private final List<DepartMessage> departMessages;

    public DepartMessageOptResp(int code, String msg, List<DepartMessage> departMessages) {
        super(code, msg);
        this.departMessages = departMessages;
    }

    @Override
    protected int groupCode() {
        return 5;
    }

}

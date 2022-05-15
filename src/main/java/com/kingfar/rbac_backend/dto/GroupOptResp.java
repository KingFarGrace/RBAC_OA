package com.kingfar.rbac_backend.dto;

import com.kingfar.rbac_backend.pojo.GroupDetailInfo;
import com.kingfar.rbac_backend.pojo.GroupInfo;
import lombok.Getter;

/**
 * @author ZKH
 */
@Getter
public class GroupOptResp extends Response {

    private final GroupDetailInfo groupDetailInfo;

    public GroupOptResp(int code, String msg, GroupDetailInfo groupDetailInfo) {
        super(code, msg);
        this.groupDetailInfo = groupDetailInfo;
    }

    @Override
    protected int groupCode() {
        return 3;
    }

}

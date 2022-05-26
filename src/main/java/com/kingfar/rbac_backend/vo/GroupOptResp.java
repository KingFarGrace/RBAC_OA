package com.kingfar.rbac_backend.vo;

import com.kingfar.rbac_backend.pojo.GroupDetailInfo;
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

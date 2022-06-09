package com.kingfar.rbac_backend.vo;

import com.kingfar.rbac_backend.pojo.GroupMessage;
import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class GroupMessageOptResp extends Response {

    private final List<GroupMessage> groupMessages;

    public GroupMessageOptResp(int code, String msg, List<GroupMessage> groupMessages) {
        super(code, msg);
        this.groupMessages = groupMessages;
    }

    @Override
    protected int groupCode() {
        return 5;
    }

}

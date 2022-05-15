package com.kingfar.rbac_backend.dto;

import com.kingfar.rbac_backend.pojo.UserBasicInfo;
import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */

@Getter
public class UserInfoResp extends Response {

    private final UserBasicInfo basicInfo;

    private final List<String> groups;
    private final List<String> departs;
    private final List<String> roles;

    private final List<String> permCodes;

    public UserInfoResp(int code, String msg,
                        UserBasicInfo basicInfo,
                        List<String> groups,
                        List<String> departs,
                        List<String> roles,
                        List<String> permCodes) {
        super(code, msg);
        this.basicInfo = basicInfo;
        this.groups = groups;
        this.departs = departs;
        this.roles = roles;
        this.permCodes = permCodes;
    }

    @Override
    protected int groupCode() {
        return 1;
    }

}

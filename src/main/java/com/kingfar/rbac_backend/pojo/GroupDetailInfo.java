package com.kingfar.rbac_backend.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author ZKH
 */
@Data
public class GroupDetailInfo {

    private String gid;
    private String gname;
    private String gcode;
    private int groupMemberCount;
    private List<String> groupMembers;

}

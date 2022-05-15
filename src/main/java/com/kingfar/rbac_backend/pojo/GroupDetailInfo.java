package com.kingfar.rbac_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ZKH
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDetailInfo {

    private String gid;
    private String gname;
    private String gcode;
    private int groupMemberCount;
    private List<String> groupMembers;

}

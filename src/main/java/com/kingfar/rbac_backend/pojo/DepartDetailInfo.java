package com.kingfar.rbac_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author ZKH
 */
@Data
@AllArgsConstructor
public class DepartDetailInfo {

    private String did;
    private String dname;
    private String dcode;
    private int departMemberCount;
    private List<String> departMembers;

}

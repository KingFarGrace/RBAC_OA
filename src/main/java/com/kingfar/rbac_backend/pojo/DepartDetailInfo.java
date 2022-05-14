package com.kingfar.rbac_backend.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author ZKH
 */
@Data
public class DepartDetailInfo {

    private String did;
    private String dname;
    private String dcode;
    private int departMemberCount;
    private List<String> departMembers;

}

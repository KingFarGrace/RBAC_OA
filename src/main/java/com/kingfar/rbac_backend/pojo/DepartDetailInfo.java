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
public class DepartDetailInfo {

    private String did;
    private String dname;
    private String dcode;
    private int departMemberCount;
    private List<String> departMembers;

}

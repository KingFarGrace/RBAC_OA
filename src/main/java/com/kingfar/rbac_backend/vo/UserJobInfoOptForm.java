package com.kingfar.rbac_backend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ZKH
 */
@Data
@AllArgsConstructor
public class UserJobInfoOptForm {

    private String uid;
    private String whichJobToArrange;
    private String jobName;
    private boolean isLeader;

}

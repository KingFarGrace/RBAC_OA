package com.kingfar.rbac_backend.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class UserJobInfoOptForm extends Form{

    private final String whichJobToArrange;
    private final String jobName;
    private final boolean isLeader;

    public UserJobInfoOptForm(String uid, List<String> permCodes, String whichJobToArrange, String jobName, boolean isLeader) {
        super(uid, permCodes);
        this.whichJobToArrange = whichJobToArrange;
        this.jobName = jobName;
        this.isLeader = isLeader;
    }
}

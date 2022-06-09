package com.kingfar.rbac_backend.pojo;

import lombok.Data;

/**
 * @author ZKH
 */
@Data
public class GroupMessage {

    private int mid;
    private int gid;
    private String content;
    private String uid;
    private boolean isFromUser;

}

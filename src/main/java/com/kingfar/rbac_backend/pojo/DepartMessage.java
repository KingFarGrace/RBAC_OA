package com.kingfar.rbac_backend.pojo;

import lombok.Data;

/**
 * @author ZKH
 */
@Data
public class DepartMessage {

    private int mid;
    private int did;
    private String content;
    private String uid;
    private boolean isFromUser;

}

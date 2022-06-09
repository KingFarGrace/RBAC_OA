package com.kingfar.rbac_backend.dto;

import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class MessagePostForm extends Form {

    private final String content;
    private final String fieldToPost;
    private final String fieldName;

    public MessagePostForm(String uid, List<String> permCodes, String content, String fieldToPost, String fieldName) {
        super(uid, permCodes);
        this.content = content;
        this.fieldToPost = fieldToPost;
        this.fieldName = fieldName;
    }

}

package com.kingfar.rbac_backend.dto;

import com.kingfar.rbac_backend.pojo.PersonalInfo;
import lombok.Getter;

import java.util.List;

/**
 * @author ZKH
 */
@Getter
public class PersonalInfosEntryForm extends Form {

    private final List<PersonalInfo> infos;

    public PersonalInfosEntryForm(String uid, List<String> permCodes, List<PersonalInfo> infos) {
        super(uid, permCodes);
        this.infos = infos;
    }
}

package com.kingfar.rbac_backend.vo;

import com.kingfar.rbac_backend.pojo.PersonalInfo;
import lombok.Data;

import java.util.List;

/**
 * @author ZKH
 */
@Data
public class PersonalInfosEntryForm {

    private List<PersonalInfo> infos;

}

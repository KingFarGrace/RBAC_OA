package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.vo.JobInfoOptForm;
import org.springframework.stereotype.Service;

/**
 * @author ZKH
 */
public interface JobArrangementService {

    /**
     * query {@link com.kingfar.rbac_backend.pojo.GroupDetailInfo}
     * @param groupName name of group
     * @return see details in {@link com.kingfar.rbac_backend.dto.GroupOptResp}
     */
    Response queryGroupInfo(String groupName);

    /**
     * query {@link com.kingfar.rbac_backend.pojo.DepartDetailInfo}
     * @param departName name of department
     * @return see details in {@link com.kingfar.rbac_backend.dto.DepartOptResp}
     */
    Response queryDepartInfo(String departName);

    Response setNewGroup(String groupName);

    Response setNewDepart(String departName);

    Response setNewRole(String roleName);

    Response setNewJobInfo(JobInfoOptForm form);

}

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

    /**
     * set a new group with random 8-bit code
     * @param groupName name of group
     * @return see details in {@link com.kingfar.rbac_backend.dto.GroupOptResp}
     */
    Response setNewGroup(String groupName);

    /**
     * set a new department with random 8-bit code
     * @param departName name of department
     * @return see details in {@link com.kingfar.rbac_backend.dto.DepartOptResp}
     */
    Response setNewDepart(String departName);

    /**
     * set a new role with random 8-bit code
     * @param roleName name of role
     * @return see details in {@link com.kingfar.rbac_backend.dto.RoleOptResp}
     */
    Response setNewRole(String roleName);

    /**
     * set new job information (group, department, role) which decide by {@link com.kingfar.rbac_backend.vo.JobInfoOptForm}
     * @param form
     * @return see details in {@link com.kingfar.rbac_backend.dto.GroupOptResp}
     * maybe DepartOptResp is also OK...
     */
    Response setNewJobInfo(JobInfoOptForm form);

}

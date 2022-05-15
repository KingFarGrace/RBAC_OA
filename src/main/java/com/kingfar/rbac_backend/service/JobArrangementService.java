package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.vo.JobInfoOptForm;
import com.kingfar.rbac_backend.vo.UserJobInfoOptForm;

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
     * query job information (contains group, department)
     * @param form {@link JobInfoOptForm}
     * @return decided by JobInfoOptForm.whichAttrToOpt,
     * group - {@link com.kingfar.rbac_backend.dto.GroupOptResp},
     * department - {@link com.kingfar.rbac_backend.dto.DepartOptResp},
     * else - {@link com.kingfar.rbac_backend.dto.GroupOptResp}
     */
    Response queryJobInfo(JobInfoOptForm form);

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
     * @param form {@link JobInfoOptForm}
     * @return see details in {@link com.kingfar.rbac_backend.dto.GroupOptResp}
     * maybe DepartOptResp is also OK...
     */
    Response setNewJobInfo(JobInfoOptForm form);

    /**
     * set user in certain group (cannot set the same user into one group twice or more)
     * @param uid uid
     * @param groupName name of group
     * @return {@link com.kingfar.rbac_backend.dto.GroupOptResp}
     */
    Response setUserInGroup(String uid, String groupName, boolean idLeader);

    /**
     * set user in certain department (cannot set the same user into one group twice or more)
     * @param uid uid
     * @param departName name of department
     * @return {@link com.kingfar.rbac_backend.dto.DepartOptResp}
     */
    Response setUserInDepartment(String uid, String departName, boolean isLeader);

    /**
     * distribute role to user (cannot distribute if user has had this role)
     * @param uid uid
     * @param roleName name of role
     * @return {@link com.kingfar.rbac_backend.dto.RoleOptResp}
     */
    Response setUserInRole(String uid, String roleName);

    /**
     * arrange a job to user (job contains: group, department, role)
     * @param form {@link UserJobInfoOptForm}
     * @return {@link com.kingfar.rbac_backend.dto.GroupOptResp}
     */
    Response setUserInJob(UserJobInfoOptForm form);

}

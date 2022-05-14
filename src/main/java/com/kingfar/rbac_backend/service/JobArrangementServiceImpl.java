package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.DepartOptResp;
import com.kingfar.rbac_backend.dto.GroupOptResp;
import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.dto.RoleOptResp;
import com.kingfar.rbac_backend.mapper.JobArrangementMapper;
import com.kingfar.rbac_backend.pojo.*;
import com.kingfar.rbac_backend.utils.RandomUtil;
import com.kingfar.rbac_backend.vo.JobInfoOptForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZKH
 */
@Service
public class JobArrangementServiceImpl implements JobArrangementService {

    private static final String ATTR_GROUP = "group";
    private static final String ATTR_DEPART = "depart";
    private static final String ATTR_ROLE = "role";

    @Autowired
    JobArrangementMapper jobArrangementMapper;

    @Override
    public Response queryGroupInfo(String groupName) {
        try {
            GroupDetailInfo info = jobArrangementMapper.queryGroupDetailInfo(groupName);
            if (info != null) {
                return new GroupOptResp(0, "success", info);
            } else {
                return new GroupOptResp(1, String.format("group(%s) does not exists (or have no member).", groupName), null);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new GroupOptResp(4, "server error, please try later.", null);
        }
    }

    @Override
    public Response queryDepartInfo(String departName) {
        try {
            DepartDetailInfo info = jobArrangementMapper.queryDepartDetailInfo(departName);
            if (info != null) {
                return new DepartOptResp(0, "success", info);
            } else {
                return new DepartOptResp(1, String.format("department(%s) does not exists (or have no member).", departName), null);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new DepartOptResp(4, "server error, please try later.", null);
        }
    }

    @Override
    public Response setNewGroup(String groupName) {
        try {
            if (jobArrangementMapper.countGroupNumberByName(groupName) != 0) {
                return new GroupOptResp(
                        3,
                        String.format("group name (%s) has been used, please change.", groupName),
                        null
                );
            }
            String code = RandomUtil.generateRandomCode(8);
            while (jobArrangementMapper.countGroupNumberByCode(code) != 0) {
                code = RandomUtil.generateRandomCode(8);
            }
            if (jobArrangementMapper.setNewGroup(groupName, code)) {
                GroupInfo info = jobArrangementMapper.queryGroupInfoByGroupName(groupName);
                return new GroupOptResp(
                        0,
                        "success",
                        new GroupDetailInfo(
                                info.getGid(),
                                info.getGname(),
                                info.getGcode(),
                                0,
                                null
                        )
                );
            } else {
                return new GroupOptResp(
                        6,
                        "set new group failed by unknown reason, please try again.",
                        null
                );
            }
        } catch (Exception e) {
            return new GroupOptResp(
                    4,
                    "server error, please try later.",
                    null
            );
        }
    }

    @Override
    public Response setNewDepart(String departName) {
        try {
            if (jobArrangementMapper.countDepartNumberByName(departName) != 0) {
                return new DepartOptResp(
                        3,
                        String.format("department name (%s) has been used, please change.", departName),
                        null
                );
            }
            String code = RandomUtil.generateRandomCode(8);
            while (jobArrangementMapper.countDepartNumberByCode(code) != 0) {
                code = RandomUtil.generateRandomCode(8);
            }
            if (jobArrangementMapper.setNewDepartment(departName, code)) {
                DepartInfo info = jobArrangementMapper.queryDepartInfoByDepartName(departName);
                return new DepartOptResp(
                        0,
                        "success",
                        new DepartDetailInfo(
                                info.getDid(),
                                info.getDname(),
                                info.getDcode(),
                                0,
                                null
                        )
                );
            } else {
                return new DepartOptResp(
                        6,
                        "set new department failed by unknown reason, please try again.",
                        null
                );
            }
        } catch (Exception e) {
            return new DepartOptResp(
                    4,
                    "server error, please try later.",
                    null
            );
        }
    }

    @Override
    public Response setNewRole(String roleName) {
        try {
            if (jobArrangementMapper.countRoleNumberByName(roleName) != 0) {
                return new RoleOptResp(3, String.
                        format("role name (%s) has been used, please change.", roleName));
            }
            String code = RandomUtil.generateRandomCode(8);
            while (jobArrangementMapper.countRoleNumberByCode(code) != 0) {
                code = RandomUtil.generateRandomCode(8);
            }
            if (jobArrangementMapper.setNewRole(roleName, code)) {
                RoleInfo info = jobArrangementMapper.queryRoleInfoByRoleName(roleName);
                return new RoleOptResp(0, "success");
            } else {
                return new RoleOptResp(6, "set new role failed by unknown reason, please try again.");
            }
        } catch (Exception e) {
            return new RoleOptResp(4,"server error, please try later.");
        }
    }

    @Override
    public Response setNewJobInfo(JobInfoOptForm form) {
        switch (form.getWhichAttrToOpt()) {
            case ATTR_GROUP:
                return setNewGroup(form.getNewAttrName());
            case ATTR_DEPART:
                return setNewDepart(form.getNewAttrName());
            case ATTR_ROLE:
                return setNewRole(form.getNewAttrName());
            default:
                return new GroupOptResp(2, String.format("reject by server:　unauthorized update request(%s)", form.getWhichAttrToOpt()), null);
        }
    }

}

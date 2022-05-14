package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.DepartOptResp;
import com.kingfar.rbac_backend.dto.GroupOptResp;
import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.mapper.JobArrangementMapper;
import com.kingfar.rbac_backend.pojo.DepartDetailInfo;
import com.kingfar.rbac_backend.pojo.GroupDetailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZKH
 */
@Service
public class JobArrangementServiceImpl implements JobArrangementService {

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

}

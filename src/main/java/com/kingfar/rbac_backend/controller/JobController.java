package com.kingfar.rbac_backend.controller;

import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.service.JobArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZKH
 */
@RestController
public class JobController {

    @Autowired
    JobArrangementService jobArrangementService;

    @PostMapping("/queryGroupInfo")
    Response getGroupInfo(String groupName) {
        return jobArrangementService.queryGroupInfo(groupName);
    }

    @PostMapping("/queryDepartInfo")
    Response getDepartInfo(String departName) {
        return jobArrangementService.queryDepartInfo(departName);
    }

}

package com.kingfar.rbac_backend.controller;

import com.kingfar.rbac_backend.dto.Response;
import com.kingfar.rbac_backend.service.JobArrangementService;
import com.kingfar.rbac_backend.vo.JobInfoOptForm;
import com.kingfar.rbac_backend.vo.UserJobInfoOptForm;
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

    @PostMapping("/queryJobInfo")
    Response getJobInfo(@RequestBody JobInfoOptForm form) {
        return jobArrangementService.queryJobInfo(form);
    }

    @PostMapping("/setJobInfo")
    Response setJobInfo(@RequestBody JobInfoOptForm form) {
        return jobArrangementService.setNewJobInfo(form);
    }

    @PostMapping("/arrangeJob")
    Response arrangeJobForUser(@RequestBody UserJobInfoOptForm form) {
        return jobArrangementService.setUserInJob(form);
    }

}

package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.Response;
import org.springframework.stereotype.Service;

/**
 * @author ZKH
 */
public interface JobArrangementService {

    Response queryGroupInfo(String groupName);

}

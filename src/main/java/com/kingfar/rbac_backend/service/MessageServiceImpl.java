package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.MessagePostForm;
import com.kingfar.rbac_backend.dto.MessageQueryForm;
import com.kingfar.rbac_backend.mapper.MessageMapper;
import com.kingfar.rbac_backend.pojo.DepartMessage;
import com.kingfar.rbac_backend.pojo.GroupMessage;
import com.kingfar.rbac_backend.vo.DepartMessageOptResp;
import com.kingfar.rbac_backend.vo.GroupMessageOptResp;
import com.kingfar.rbac_backend.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZKH
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    private static final String DEPART_FIELD = "department";
    private static final String GROUP_FIELD = "group";
    private static final String ADMIN_ID = "000000000000";
    private static final String SYSTEM_FIELD = "system";
    private static final int SYS_ID = 10000;
    private static final String SYSTEM_NAME = "系统占位";

    @Override
    public Response postSystemAnnouncement(String content) {
        if (messageMapper.setDepartMessage(SYSTEM_NAME, ADMIN_ID, content, false)) {
            System.out.println("department");
            return new DepartMessageOptResp(0, "success", null);
        } else {
            return new DepartMessageOptResp(1, "failed to publish system announcement.", null);
        }
    }

    @Override
    public Response postDepartAnnouncement(String departName, String content) {
        if (messageMapper.setDepartMessage(departName, ADMIN_ID, content, false)) {
            System.out.println("department");
            return new DepartMessageOptResp(0, "success", null);
        } else {
            return new DepartMessageOptResp(1, String.format("failed to find department: (%s)", departName), null);
        }
    }

    @Override
    public Response postGroupAnnouncement(String groupName, String content) {
        if (messageMapper.setGroupMessage(groupName, ADMIN_ID, content, false)) {
            System.out.println("group");
            return new GroupMessageOptResp(0, "success", null);
        } else {
            return new GroupMessageOptResp(1, String.format("failed to find group: (%s)", groupName), null);
        }
    }

    @Override
    public Response postAnnouncement(MessagePostForm form) {
        try {
            switch (form.getFieldToPost()) {
                case DEPART_FIELD:
                    return postDepartAnnouncement(form.getFieldName(), form.getContent());
                case GROUP_FIELD:
                    return postGroupAnnouncement(form.getFieldName(), form.getContent());
                case SYSTEM_FIELD:
                    return postSystemAnnouncement(form.getContent());
                default:
                    return new GroupMessageOptResp(2, String.format("unauthorized request field: (%s)", form.getFieldToPost()), null);
            }
        } catch (Exception e) {
            return new GroupMessageOptResp(4, String.format("server error, please try again.(%s)", e.getMessage()), null);
        }
    }

    @Override
    public Response applyAuthorization(String uid, String permName, String departName) {
        return null;
    }

    @Override
    public Response replyAuthorization(String uid, String permName, String departName) {
        return null;
    }

    @Override
    public Response chat(MessagePostForm form) {
        try {
            if (!form.getFieldToPost().equals(GROUP_FIELD)) {
                return new GroupMessageOptResp(2, String.format("unauthorized request field: (%s)", form.getFieldToPost()), null);
            }
            if (messageMapper.setGroupMessage(form.getFieldName(), form.getUid(), form.getContent(), true)) {
                return new GroupMessageOptResp(0, "success", null);
            } else {
                return new GroupMessageOptResp(1, String.format("failed to find group: (%s)", form.getFieldName()), null);
            }
        } catch (Exception e) {
            return new GroupMessageOptResp(4, String.format("server error, please try again.(%s)", e.getMessage()), null);
        }
    }

    @Override
    public Response querySystemAnnouncement() {
        List<DepartMessage> systemAnnouncement = messageMapper.querySystemAnnouncement();
        if (systemAnnouncement != null) {
            return new DepartMessageOptResp(0, "success", messageMapper.querySystemAnnouncement());
        } else {
            return new DepartMessageOptResp(1, "failed to get system announcements", null);
        }
    }

    @Override
    public Response queryDepartAnnouncement(String departName) {
        List<DepartMessage> departAnnouncement = messageMapper.queryDepartAnnouncement(departName);
        if (departAnnouncement != null) {
            return new DepartMessageOptResp(0, "success", departAnnouncement);
        } else {
            return new DepartMessageOptResp(1, String.format("failed to find department: (%s)", departName), null);
        }
    }

    @Override
    public Response queryGroupAnnouncement(String groupName) {
        List<GroupMessage> groupAnnouncement = messageMapper.queryGroupAnnouncement(groupName);
        if (groupAnnouncement != null) {
            return new GroupMessageOptResp(0, "success", groupAnnouncement);
        } else {
            return new GroupMessageOptResp(1, String.format("failed to find group: (%s)", groupName), null);
        }
    }

    @Override
    public Response queryAnnouncement(MessageQueryForm form) {
        try {
            switch (form.getFieldToQuery()) {
                case DEPART_FIELD:
                    return queryDepartAnnouncement(form.getFieldName());
                case GROUP_FIELD:
                    return queryGroupAnnouncement(form.getFieldName());
                case SYSTEM_FIELD:
                    return querySystemAnnouncement();
                default:
                    return new GroupMessageOptResp(2, String.format("unauthorized request field: (%s)", form.getFieldToQuery()), null);
            }
        } catch (Exception e) {
            return new GroupMessageOptResp(4, String.format("server error, please try again.(%s)", e.getMessage()), null);
        }
    }

    @Override
    public Response queryGroupMessages(MessageQueryForm form) {
        try {
            if (!form.getFieldToQuery().equals(GROUP_FIELD)) {
                return new GroupMessageOptResp(2, String.format("unauthorized request field: (%s)", form.getFieldToQuery()), null);
            }
            List<GroupMessage> groupMessages = messageMapper.queryGroupMessage(form.getFieldName(), form.getUid());
            if (groupMessages == null) {
                return new GroupMessageOptResp(1, String.format("failed to find group: (%s)", form.getFieldName()), null);
            } else {
                return new GroupMessageOptResp(0, "success", groupMessages);
            }
        } catch (Exception e) {
            return  new GroupMessageOptResp(4, String.format("server error, please try again.(%s)", e.getMessage()), null);
        }
    }

}

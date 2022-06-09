package com.kingfar.rbac_backend.service;

import com.kingfar.rbac_backend.dto.Form;
import com.kingfar.rbac_backend.dto.MessagePostForm;
import com.kingfar.rbac_backend.dto.MessageQueryForm;
import com.kingfar.rbac_backend.vo.Response;
import sun.plugin2.message.Message;

/**
 * @author ZKH
 */
public interface MessageService {

    /**
     * publish system announcement
     * @param content
     * @return
     */
    Response postSystemAnnouncement(String content);

    /**
     * publish department announcement
     * @param departName
     * @param content
     * @return
     */
    Response postDepartAnnouncement(String departName, String content);

    /**
     * publish group announcement
     * @param groupName
     * @param content
     * @return
     */
    Response postGroupAnnouncement(String groupName, String content);

    /**
     * publish announcement
     * @param form
     * @return
     */
    Response postAnnouncement(MessagePostForm form);

    /**
     * user apply for new permission
     * @param uid
     * @param permName
     * @param departName
     * @return
     */
    Response applyAuthorization(String uid, String permName, String departName);

    /**
     * department administrator reply for member's authorize application
     * @param uid
     * @param permName
     * @param departName
     * @return
     */
    Response replyAuthorization(String uid, String permName, String departName);

    /**
     * send message in group
     * @param form
     * @return
     */
    Response chat(MessagePostForm form);

    /**
     * search system announcements
     * @return
     */
    Response querySystemAnnouncement();

    /**
     * search department announcements
     * @param departName
     * @return
     */
    Response queryDepartAnnouncement(String departName);

    /**
     * search group announcements
     * @param groupName
     * @return
     */
    Response queryGroupAnnouncement(String groupName);

    /**
     * search announcements(system/group/department)
     * @param form
     * @return
     */
    Response queryAnnouncement(MessageQueryForm form);

    /**
     * search group messages
     * @param form
     * @return
     */
    Response queryGroupMessages(MessageQueryForm form);

}

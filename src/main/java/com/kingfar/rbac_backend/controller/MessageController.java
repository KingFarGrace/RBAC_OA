package com.kingfar.rbac_backend.controller;

import com.kingfar.rbac_backend.dto.MessagePostForm;
import com.kingfar.rbac_backend.dto.MessageQueryForm;
import com.kingfar.rbac_backend.service.MessageService;
import com.kingfar.rbac_backend.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZKH
 */
@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/message/post")
    public Response postMessage(@RequestBody MessagePostForm form) {
        return messageService.postAnnouncement(form);
    }

    @PostMapping("/chat")
    public Response chat(@RequestBody MessagePostForm form) {
        return messageService.chat(form);
    }

    @PostMapping("/announcement")
    public Response queryAnnouncements(@RequestBody MessageQueryForm form) {
        return messageService.queryAnnouncement(form);
    }

    @PostMapping("/getChatMessages")
    public Response getChatMessages(@RequestBody MessageQueryForm form) {
        return messageService.queryGroupMessages(form);
    }

}

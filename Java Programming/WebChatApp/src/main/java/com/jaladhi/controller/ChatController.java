package com.jaladhi.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.jaladhi.model.Message;
import com.jaladhi.repository.MessageRepository;

@Controller
public class ChatController {

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	private MessageRepository messageRepository;

	@MessageMapping("/messages")
    public void handleMessage(Message message) {
		message.setTimestamp(new Date());
		messageRepository.save(message);
		template.convertAndSend("/channel/chat/" + message.getChannel(), message);
    }
}

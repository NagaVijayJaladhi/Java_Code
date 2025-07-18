package com.jaladhi.controller;

import com.jaladhi.model.Message;
import com.jaladhi.model.ReadReceiptRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.jaladhi.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class MessageController {

	@Autowired 
	private MessageRepository messageRepository;
	
	@GetMapping(value = "/messages/{channelId}")
	public Page<Message> findMessages(Pageable pageable, @PathVariable("channelId") String channelId) {
		return messageRepository.findAllByChannel(channelId, pageable);
	}

	@PostMapping(value = "/messages")
	public void sendReadReceipt(@RequestBody ReadReceiptRequest request) {
		messageRepository.sendReadReceipt(request.getChannel(), request.getUsername());
	}
}

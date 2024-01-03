package com.uijin.redischat.controller;

import com.uijin.redischat.model.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {
  private final SimpMessageSendingOperations simpMessageSendingOperations;

  @MessageMapping("/message")
  public void message(MessageRequest message) {
    simpMessageSendingOperations.convertAndSend("/sub/" + message.getChannelId(), message.getMessage());
  }
}

package com.uijin.redischat.controller;

import com.uijin.redischat.model.ChatRoom;
import com.uijin.redischat.service.ChatRoomService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

  private final ChatRoomService chatRoomService;

  @PostMapping
  public ChatRoom create(@RequestParam String name) {
    return chatRoomService.create(name);
  }

  @GetMapping
  public List<ChatRoom> findAll() {
    return chatRoomService.findAll();
  }

}

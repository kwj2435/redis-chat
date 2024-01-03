package com.uijin.redischat.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChatRoom {
  private String roomId;
  private String name;

  public ChatRoom(String name) {
    this.roomId = UUID.randomUUID().toString();
    this.name = name;
  }
}

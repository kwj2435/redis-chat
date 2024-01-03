package com.uijin.redischat.model;

import lombok.Getter;

@Getter
public class MessageRequest {
  private String channelId;
  private String message;
}

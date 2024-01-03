package com.uijin.redischat.service;

import com.uijin.redischat.model.ChatRoom;
import com.uijin.redischat.repository.ChatRoomRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

  private final ChatRoomRepository chatRoomRepository;

  public ChatRoom create(String name) {
    return chatRoomRepository.create(name);
  }

  public List<ChatRoom> findAll() {
    return chatRoomRepository.findAll();
  }
}

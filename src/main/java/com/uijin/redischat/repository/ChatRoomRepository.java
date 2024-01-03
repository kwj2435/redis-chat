package com.uijin.redischat.repository;

import com.uijin.redischat.model.ChatRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomRepository {
  private Map<String, ChatRoom> chatRoomDB = new HashMap<>();

  public List<ChatRoom> findAll() {
    return new ArrayList<>(chatRoomDB.values());
  }

  public ChatRoom create(String name) {
    ChatRoom chatRoom = new ChatRoom(name);
    chatRoomDB.put(chatRoom.getRoomId(), chatRoom);

    return chatRoom;
  }
}

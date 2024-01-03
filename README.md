## Redis Pub/Sub 기반의 실시간 채팅 구현

### How To Run
```
1. docker 빌드하고 실행하면 동작함
```

동작순서 정리
1. 클라이언트와 서버가 웹 소켓 연결
2. 클라이언트는 서버의 특정 토픽을 Subscribe 하게됨 (웹 소켓 계속 유지)
3. 구독중인 토픽으로 새로운 메시지가 Publish 되면 Subscribe 중인 모든 클라이언트가 메시지를 전달받음

### Redis Pub/Sub
### STOMP
- 텍스트 기반의 메시징 프로토콜
### Sock.js
- SockJs는 WebSocket 프로토콜의 대안으로 사용되는 브라우저 클라이언트와 웹 서버 간의 양방향 통신을 지원하는 JS 라이브러리  
WebSocket은 클라이언트와 웹 서버 간의 양방향 통신을 지원하지만, 모든 브라우저에서 지원되지는 않는다.  
이를 보완하기 위해 SockJS를 사용한다.

Pub/Sub 구조는 서로 직접 통신하는 것이 아닌 Message Broker를 통해 메시지를 전달하는 구조이다.
Message Broker는 Publisher가 보낸 메시지를 Subcriber로 전달해주는 미들웨어 역할을 한다.

Spring에서 제공하는 내장 Simple Message Broker를 사용해서 구현할 수 있으나 인메모리 기반 브로커를 사용할 경우
서버가 down되거나 재시작될 경우 메시지 큐에 있는 데이터가 유실될 수 있으며, 서버가 다중으로 존재할 경우
서버별로 사용자가 분산되어 서로간 채팅이 불가능하다.

Redis가 제공하는 Pub/Sub 기능을 통해 메시지 브로커로 사용할 수 있다.

다만 Redis의 경우 STOMP 프로토콜을 지원하지 않으며, 메시지 전송을 보장하지 않는다.
(메시지 전달후 삭제되어버림)

메시지 전송을 보장하기 위해서는 RabbitMQ 혹은 Kafka를 사용해야한다.  
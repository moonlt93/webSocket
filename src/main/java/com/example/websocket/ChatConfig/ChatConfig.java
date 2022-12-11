package com.example.websocket.ChatConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer {
//message Broker에 대한 설정

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*").withSockJS();
        // 연결할 소켓 엔드포인트를 지정,패턴에 해당하는 모든 경로를 추가해서 소캣을 등록

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // 메시지 브로커를 등록하는 코드
        registry.enableSimpleBroker("/queue", "/topic");

        registry.setApplicationDestinationPrefixes("/app");
        //도착 경로에 대한 prefix => /topic/hello 라는 토픽의 실제 경로는
        // //  /app/topic/hello 가 된다.

    }
}

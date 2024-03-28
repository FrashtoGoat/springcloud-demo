package com.xiaoluban.thirdparty.controller;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;  
import org.springframework.web.socket.handler.TextWebSocketHandler;  
  
public class MyWebSocketHandler extends TextWebSocketHandler {  
  
    @Override  
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {  
        System.out.println("Client connected: " + session.getId());  
    }  
  
    @Override  
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {  
        System.out.println("Message from client: " + message.getPayload());  
        // 发送消息回客户端  
        session.sendMessage(new TextMessage("Message received: " + message.getPayload()));  
    }  
  
    @Override  
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Client disconnected: " + session.getId());  
    }  
  
    @Override  
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {  
        System.err.println("WebSocket Transport Error: " + exception.getMessage());  
    }  
}
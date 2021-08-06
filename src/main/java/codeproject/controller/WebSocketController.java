package codeproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import codeproject.model.ChatMessage;


 
@Controller
public class WebSocketController {
 
	 @Autowired
	 private SimpMessageSendingOperations messagingTemplate;
	
	
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
    	System.out.println(chatMessage.getSender());
    	  messagingTemplate.convertAndSend("/topic/" + chatMessage.getRoom(), chatMessage);
//        return chatMessage;
    }
 
    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        headerAccessor.getSessionAttributes().put("phong", chatMessage.getRoom());
        messagingTemplate.convertAndSend("/topic/" + chatMessage.getRoom() , chatMessage);
//        return chatMessage;
    }
    
    
 
}


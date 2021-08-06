package codeproject.controller;

import codeproject.model.ChatMessage;
import codeproject.model.Comment;
import codeproject.model.User;
import codeproject.repository.UserRepository;
import codeproject.service.CommentService;
import codeproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/test")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    
    @Autowired
	UserRepository userRepository;
    
    @Autowired
	UserService userService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComment();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        Comment comment = commentService.getComment(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
    	String name = comment.getUser().getName();
    	
    	ChatMessage chatMessage = new ChatMessage();
    	chatMessage.setSender(name);
    	chatMessage.setContent(comment.getContent());
    	chatMessage.setType(ChatMessage.MessageType.CHAT);
    	messagingTemplate.convertAndSend("/topic/" + comment.getProject().getEventName(), chatMessage);
    	
        return new ResponseEntity<>(commentService.addComment(comment), HttpStatus.OK);
    }
}


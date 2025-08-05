package com.example.hello.controller;

import com.example.hello.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<String> saveMessage(@RequestBody String messageContent) {
        messageService.saveMessage(messageContent);
        return new ResponseEntity<>("Message saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<String> getAllMessages() {
        return messageService.getAllMessageContents();
    }
}

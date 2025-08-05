package com.example.dbtrial.controller;

import com.example.dbtrial.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public ResponseEntity<Void> saveMessage(@RequestBody String message) {
        messageService.saveMessage(message);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<String>> getAllMessages() {
        List<String> messages = messageService.getAllMessageContents();
        return ResponseEntity.ok(messages);
    }
}

package com.example.dbtry.controller;

import com.example.dbtry.model.Message;
import com.example.dbtry.service.MessageService;
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
    public ResponseEntity<Void> addMessage(@RequestBody String content) {
        messageService.saveMessage(content);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<String>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }
}


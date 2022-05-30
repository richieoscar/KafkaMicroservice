package com.richieoscar.kafkaexample.controllers;

import com.richieoscar.kafkaexample.dto.Message;
import com.richieoscar.kafkaexample.dto.MessageRequest;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/api/v1/messages")
@AllArgsConstructor
public class KafkaController {
    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping("/publish")
    void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("chatty",new Message("Notice", request.getMessage(), "12:00"));
    }
}

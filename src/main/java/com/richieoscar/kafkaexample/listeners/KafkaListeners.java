package com.richieoscar.kafkaexample.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.richieoscar.kafkaexample.dto.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics ="chatty", groupId = "users")
    void listener(String data){
        Message message = null;
        try {
          message=  new ObjectMapper().readValue(data, Message.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("Listener received " + message +" :)");
    }
}

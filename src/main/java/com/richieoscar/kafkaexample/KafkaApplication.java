package com.richieoscar.kafkaexample;

import com.richieoscar.kafkaexample.dto.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalTime;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Message> kafkaTemplate) {
        return args -> {
            for (int i = 0; i <= 100; i++) {
                kafkaTemplate.send("chatty",
                        new Message("Hi",
                                "Hello This is Awesome i am learning kafka Messaging Queuse!!!",
                                "12:22"));
            }
        };
    }
}

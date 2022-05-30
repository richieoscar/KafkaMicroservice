package com.richieoscar.kafkaexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String title;
    private String content;
    private String sent;
}

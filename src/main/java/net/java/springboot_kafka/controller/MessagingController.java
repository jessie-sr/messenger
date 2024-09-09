package net.java.springboot_kafka.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.java.springboot_kafka.service.KafkaConsumerService;
import net.java.springboot_kafka.service.KafkaProducerService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class MessagingController {

    private final KafkaConsumerService kafkaConsumerService;
    private final KafkaProducerService kafkaProducerService;


    @MessageMapping("/produce")
    public void sendMessage(String message) {
        // Storing STOMP message in Kafka
        kafkaProducerService.createKafkaMessage(message);
    }

    @GetMapping("/get_all")
    public ArrayList<String> getAllMessages(HttpServletRequest request) {
        // Get all messages from Server-Session
        // This can be changed by using a DB or Elastic Cache
        return kafkaConsumerService.getConsumedKafkaMessages();
    }
}
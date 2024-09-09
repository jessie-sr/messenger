package net.java.springboot_kafka.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.java.springboot_kafka.constant.KafkaConstant;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Getter
@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;


    public void createKafkaMessage(String message) {
        kafkaTemplate.send(KafkaConstant.KAFKA_TOPIC, message);
    }
}

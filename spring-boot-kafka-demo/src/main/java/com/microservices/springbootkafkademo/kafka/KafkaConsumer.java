package com.microservices.springbootkafkademo.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics="${spring.kafka.topic.name}",groupId = "employee-group")
    public void consume(String message) {
        log.info(String.format("Message Received -> %s", message));
    }
}

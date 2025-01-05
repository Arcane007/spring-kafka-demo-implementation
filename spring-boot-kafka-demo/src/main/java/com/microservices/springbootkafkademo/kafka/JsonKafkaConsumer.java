package com.microservices.springbootkafkademo.kafka;

import com.microservices.springbootkafkademo.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name2}",groupId = "employee-group")
    public void jsonConsumer(User user)
    {
        log.info("Received JSON message: {}", user.toString());
    }
}

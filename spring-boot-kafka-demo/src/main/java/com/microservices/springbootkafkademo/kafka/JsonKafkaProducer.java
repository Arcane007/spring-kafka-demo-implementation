package com.microservices.springbootkafkademo.kafka;

import com.microservices.springbootkafkademo.payload.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {

    @Value("${spring.kafka.topic.name2}")
    private String topicName;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        log.info("Sending message='{}'", user.toString());
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,topicName)
                .build();

        kafkaTemplate.send(message);
    }
}

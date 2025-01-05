package com.microservices.springbootkafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name}")
    private String KAFKA_TOPIC;
    @Value("${spring.kafka.topic.name2}")
    private String KAFKA_TOPIC2;

    @Bean
    public NewTopic employeeTopic(){
        return TopicBuilder.name(KAFKA_TOPIC).build();
    }

    @Bean
    public NewTopic employeeJsonTopic(){
        return TopicBuilder.name(KAFKA_TOPIC2).build();
    }
}

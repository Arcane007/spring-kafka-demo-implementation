package com.microservices.springbootkafkademo.controller;


import com.microservices.springbootkafkademo.kafka.JsonKafkaProducer;
import com.microservices.springbootkafkademo.kafka.KafkaProducer;
import com.microservices.springbootkafkademo.payload.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class MessageController {

    private KafkaProducer kafkaProducer;
    private JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message published successfully");
    }

    @PostMapping("/jsonpublish")
    public ResponseEntity<String> JsonMessagePublish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message published successfully");
    }
}

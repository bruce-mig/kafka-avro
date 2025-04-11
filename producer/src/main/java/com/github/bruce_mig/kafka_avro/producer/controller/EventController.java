package com.github.bruce_mig.kafka_avro.producer.controller;

import com.github.bruce_mig.kafka_avro.dto.Employee;
import com.github.bruce_mig.kafka_avro.producer.KafkaAvroProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    private final KafkaAvroProducer producer;

    public EventController(KafkaAvroProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/events")
    public String sendMessage(@RequestBody Employee employee){
        producer.send(employee);
        return "Message published!";
    }
}

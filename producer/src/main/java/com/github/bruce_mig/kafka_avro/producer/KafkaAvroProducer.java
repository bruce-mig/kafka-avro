package com.github.bruce_mig.kafka_avro.producer;

import com.github.bruce_mig.kafka_avro.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaAvroProducer {

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Employee> template;

    public KafkaAvroProducer(KafkaTemplate<String, Employee> template) {
        this.template = template;
    }

    public void send(Employee employee){
        CompletableFuture<SendResult<String, Employee>> future = template.send(topicName, UUID.randomUUID().toString(),employee);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[{}] to topic=[{}] with offset=[{}]", employee,topicName, result.getRecordMetadata().offset());
            } else {
                log.error("Unable to send message=[{}] due to : {}", employee, ex.getMessage());
            }
        });
    }
}

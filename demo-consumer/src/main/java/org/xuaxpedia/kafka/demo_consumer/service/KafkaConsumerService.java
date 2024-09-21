package org.xuaxpedia.kafka.demo_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "miprimertopico", groupId = "consumer-group")
    public void listen(String message) {
        System.out.println("Mensaje recibido en el consumidor: " + message);
    }
}

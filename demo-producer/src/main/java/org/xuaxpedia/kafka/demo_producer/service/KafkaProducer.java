package org.xuaxpedia.kafka.demo_producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Method to send a message with a key
    public void sendEventWithKey(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message);
        System.out.println("Event sent to topic " + topic + " with key: " + key + " and message: " + message);
    }
}

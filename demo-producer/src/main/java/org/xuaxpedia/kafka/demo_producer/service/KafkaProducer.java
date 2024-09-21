package org.xuaxpedia.kafka.demo_producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Método para enviar un mensaje con clave
    public void sendEventWithKey(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message);
        System.out.println("Evento enviado al tópico " + topic + " con clave: " + key + ", y mensaje: " + message);
    }
}

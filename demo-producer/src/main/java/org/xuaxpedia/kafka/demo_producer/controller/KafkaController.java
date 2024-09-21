package org.xuaxpedia.kafka.demo_producer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xuaxpedia.kafka.demo_producer.service.KafkaProducer;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public String sendEvent(
        @RequestParam String topic, 
        @RequestParam String key, 
        @RequestParam String message) {
        kafkaProducer.sendEventWithKey(topic, key, message);
        return "Evento enviado con éxito";
    }
}

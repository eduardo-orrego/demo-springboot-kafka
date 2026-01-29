package org.xuaxpedia.kafka.demo_producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, @Value("${app.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    // Sends a message with a key
    public void sendEventWithKey(String key, String message) {
        kafkaTemplate.send(topic, key, message)
          .whenComplete((result, ex) -> {
              if (ex != null) {
                  logger.error("Failed to send event", ex);
              } else {
                  logger.info("Event sent to topic {}", topic);
              }
          });
    }
}

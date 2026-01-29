package org.xuaxpedia.kafka.demo_producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Sends a message with a key
    public void sendEventWithKey(String topic, String key, String message) {
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

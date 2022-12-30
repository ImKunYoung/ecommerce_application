package com.example.mscatalogsservice.adapter.mq;

import com.example.mscatalogsservice.entity.CatalogEntity;
import com.example.mscatalogsservice.repository.CatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final CatalogRepository repository;

    @KafkaListener(topics = "example-order-topic")
    public void processMaessage(String kafkaMessage) {
        log.info("Kafka MessageL ====>"+kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        CatalogEntity entity = repository.findByProductId((String) map.get("productId"));
        entity.setStock(entity.getStock() - (Integer) map.get("qty"));

        repository.save(entity);

    }

}

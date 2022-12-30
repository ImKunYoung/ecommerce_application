package com.example.mscatalogsservice.outer.mqadapter;

import com.example.mscatalogsservice.outer.dto.CatalogDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public CatalogDto send(String kafkaTopic, CatalogDto catalogDto) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(catalogDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(kafkaTopic, jsonInString);
        log.info("Kafka Producer send data from the ms-ordersservice: " + catalogDto);

        return catalogDto;
    }
}

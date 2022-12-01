package com.example.msuserservice.outer.mq;

import com.example.msuserservice.inner.service.domain.entity.UserEntity;
import com.example.msuserservice.inner.service.domain.entity.recentlyViewdVo;
import com.example.msuserservice.middle.CountVoRepository;
import com.example.msuserservice.middle.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {
    private final UserRepository userRepository;
    private final CountVoRepository countVoRepository;

    @KafkaListener(topics = "example-user-topic")
    @Transactional
    public void processMaessage(String kafkaMessage) {
        log.info("Kafka MessageL ====>"+kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }



        UserEntity userEntity = userRepository.findByUserId((String) map.get("userId"));

        recentlyViewdVo recentlyViewdVo = new recentlyViewdVo();
        recentlyViewdVo.setCatalog((String) map.get("productId"));
        recentlyViewdVo.setUserEntity(userEntity);

        countVoRepository.save(recentlyViewdVo);

//        userEntity.setRecentlyViewed((String) map.get("productId"));


        log.info("Kafka Consumer send data from the ms-ordersservice: " + userEntity);

//        userRepository.save(userEntity);
    }

}

```java
package com.example.mscatalogsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsCatalogsserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCatalogsserviceApplication.class, args);
    }

}
```

- ``@SpringBootApplication``: This annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. It is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes.
- ``@EnableEurekaClient``: This annotation is used to enable Eureka Client in the application.


<br/>

---------

<br/>

```java
package com.example.mscatalogsservice.web;

import com.example.mscatalogsservice.entity.CatalogEntity;
import com.example.mscatalogsservice.service.CatalogService;
import com.example.mscatalogsservice.vo.ResponseCatalog;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
//import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogController {


//    private final Environment env;

    private final CatalogService catalogService;

    /*@Description 상품 목록 조회*/
    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        Iterable<CatalogEntity> allCatalogs = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        allCatalogs.forEach(v -> result.add(new ModelMapper().map(v, ResponseCatalog.class)));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /*@Description 상태 확인*/
    @GetMapping("/health_check")
    public String status(HttpServletRequest request) {
        return String.format("It's Working in Catalog Service on PORT %s", request.getServerPort());
    }

}
```

- ``@RestController``: This annotation is used to create RESTful web services using Spring MVC. It is a convenience annotation that does nothing more than adding the @Controller and @ResponseBody annotations.
- ``@RequiredArgsConstructor``: This annotation generates a constructor with 1 parameter for each field that requires special handling. All non-initialized final fields get a parameter, as well as any fields that are marked as @NonNull that aren't initialized where they are declared.
- ``@GetMapping``: This annotation is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
- ``ResponseEntity``: This class is used to build a response entity. It contains the object to be returned as well as HTTP status code and headers.
- ``ModelMapper``: This class is used to map one object to another. It is used to map the entity object to the view object.

<br/>

---------

<br/>

```java
package com.example.mscatalogsservice.dto;

import lombok.Data;

@Data
public class CatalogDto {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;
}
```

- ``@Data``: This annotation is used to generate getters, setters, equals, hash, and toString methods, based on the fields.
- ``productId``: 상품 ID
- ``qty``: 상품 수량
- ``unitPrice``: 상품 단가
- ``totalPrice``: 상품 총 가격
- ``orderId``: 주문 ID
- ``userId``: 사용자 ID


<br/>

---------

<br/>


```java
package com.example.mscatalogsservice.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "catalog")
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;

}
```

- ``@Entity``: This annotation is used to mark a Java class as an entity so that it can be mapped to a database table.
- ``@AllArgsConstructor``: This annotation generates a constructor with 1 parameter for each field in your class.
- ``@NoArgsConstructor``: This annotation generates a constructor with no parameters.
- ``@Getter``: This annotation is used to generate getters for all fields.
- ``@Setter``: This annotation is used to generate setters for all non-final fields.
- ``@ToString``: This annotation is used to generate a toString method.
- ``@Table``: This annotation is used to specify the primary table for the annotated entity.
- ``@Id``: This annotation is used to specify the primary key of an entity.
- ``@GeneratedValue``: This annotation is used to specify the primary key generation strategy that the persistence provider must use to generate the annotated entity primary key.
- ``@Column``: This annotation is used to specify the mapped column for a persistent property or field.
- ``@ColumnDefault``: This annotation is used to specify the default value for a column.
- ``id``: 상품 ID
- ``productId``: 상품 ID
- ``productName``: 상품 이름
- ``stock``: 상품 재고
- ``unitPrice``: 상품 단가
- ``createdAt``: 상품 생성 시간


<br/>

---------

<br/>


```java
package com.example.mscatalogsservice.vo.service;

import com.example.mscatalogsservice.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}

```

- ``Iterable``: This interface is used to iterate the elements sequentially in either a forward or reverse direction. It is an extension of the ``Collection`` interface.
- ``getAllCatalogs``: 상품 목록 조회
- ``CatalogEntity``: 상품 Entity
- ``CatalogService``: 상품 Service

<br/>

---------

<br/>

```java
package com.example.mscatalogsservice.vo.service;

import com.example.mscatalogsservice.entity.CatalogEntity;
import com.example.mscatalogsservice.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    private final Environment env;

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
```

- ``@Service``: This annotation is used with classes that provide some business functionalities. It is used with classes at the service layer.
- ``@Slf4j``: This annotation is used to generate a logger field.
- ``@RequiredArgsConstructor``: This annotation generates a constructor with 1 parameter for each field that requires special handling. All non-initialized final fields get a parameter, as well as any fields that are marked as @NonNull that aren't initialized where they are declared.
- ``catalogRepository``: 상품 Repository
- ``Environment env``: 환경 변수
- ``getAllCatalogs``: 상품 목록 조회
- ``CatalogServiceImpl``: 상품 Service 구현체
- ``CatalogEntity``: 상품 Entity
- ``CatalogService``: 상품 Service
- ``CatalogRepository``: 상품 Repository


<br/>

---------

<br/>

```java
package com.example.mscatalogsservice.repository;

import com.example.mscatalogsservice.entity.CatalogEntity;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<CatalogEntity, Long> {
    CatalogEntity findByProductId(String productId);
}
```

- ``CrudRepository``: This interface provides CRUD functionality for the entity class that is being managed. This interface can be used by extending it and specifying the entity class and ID type.
- ``findByProductId``: 상품 ID로 상품 조회

<br/>

---------

<br/>


```java
package com.example.mscatalogsservice.mq;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> properties = new HashMap<>();
        // Kafka container host
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "consumerGroupId");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(properties);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return kafkaListenerContainerFactory;
    }

}
```

- ``@EnableKafka``: This annotation is used to enable detection of @KafkaListener annotations on Spring-managed beans in the current Spring application context.
- ``@Configuration``: This annotation is used to declare a class as a configuration class. It is used to declare one or more @Bean methods and also triggers auto-configuration and component scanning.
- ``@Bean``: This annotation is used to mark a method as a bean provider method. It is used to mark a method as a bean provider method. It is used to mark a method as a bean provider method.
- ``consumerFactory``: Kafka Consumer Factory
- ``kafkaListenerContainerFactory``: Kafka Listener Container Factory
- ``ConcurrentKafkaListenerContainerFactory``: This class provides a factory for creating KafkaListenerContainer instances. It is used to create KafkaListenerContainer instances.
- ``DefaultKafkaConsumerFactory``: This class provides a factory for creating KafkaConsumer instances. It is used to create KafkaConsumer instances.
- ``HashMap``: This class implements the Map interface by using a hash table. It is used to implement the Map interface by using a hash table.
- ``Map``: This interface maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
- ``StringDeserializer``: This class implements the Deserializer interface. It is used to implement the Deserializer interface.
- ``ConsumerConfig``: This class defines all the configuration keys that are used by the consumer.
- ``KafkaConsumerConfig``: Kafka Consumer Config


<br/>

---------

<br/>


```java
package com.example.mscatalogsservice.mq;

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
```

- ``@KafkaListener``: This annotation is used to mark a method to be the target of a Kafka message listener on the specified topics.
- ``@Service``: This annotation is used to mark a class as a service provider. It is used to mark a class as a service provider.
- ``@Slf4j``: This annotation is used to generate a logger field.
- ``@RequiredArgsConstructor``: This annotation generates a constructor with 1 parameter for each field that requires special handling. This annotation generates a constructor with 1 parameter for each field that requires special handling.
- ``processMaessage``: Kafka 메시지 처리
- ``ObjectMapper``: This class provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model (JsonNode), as well as related functionality for performing conversions.
- ``TypeReference``: This class is used to contain information about generic type used in a class. It is used
- ``JsonProcessingException``: This exception is thrown when processing of JSON content (reading or writing) encounters a problem.
- ``RuntimeException``: This class is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine.

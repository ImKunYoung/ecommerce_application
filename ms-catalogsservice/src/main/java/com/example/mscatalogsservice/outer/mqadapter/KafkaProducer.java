package com.example.mscatalogsservice.outer.mqadapter;

import com.example.mscatalogsservice.outer.dto.CatalogDto;

public interface KafkaProducer {

    CatalogDto send(String kafkaTopic, CatalogDto catalogDto);

}

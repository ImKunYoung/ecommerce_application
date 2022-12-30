package com.example.mscatalogsservice.service;

import com.example.mscatalogsservice.outer.dto.CatalogDto;
import com.example.mscatalogsservice.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();

    CatalogDto getCatalogByProductId(String productId);
}

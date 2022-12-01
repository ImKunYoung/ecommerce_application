package com.example.mscatalogsservice.vo.service;

import com.example.mscatalogsservice.dto.CatalogDto;
import com.example.mscatalogsservice.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();

    CatalogDto getCatalogByProductId(String productId);
}

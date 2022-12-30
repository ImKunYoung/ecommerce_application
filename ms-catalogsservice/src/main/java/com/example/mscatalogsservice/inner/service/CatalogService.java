package com.example.mscatalogsservice.inner.service;

import com.example.mscatalogsservice.outer.dto.CatalogDto;
import com.example.mscatalogsservice.inner.domain.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();

    CatalogDto getCatalogByProductId(String productId);
}

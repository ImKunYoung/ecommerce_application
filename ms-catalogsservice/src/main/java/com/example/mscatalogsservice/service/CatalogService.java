package com.example.mscatalogsservice.service;

import com.example.mscatalogsservice.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
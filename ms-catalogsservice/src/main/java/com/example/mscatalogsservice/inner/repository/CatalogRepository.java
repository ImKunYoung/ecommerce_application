package com.example.mscatalogsservice.inner.repository;

import com.example.mscatalogsservice.inner.domain.CatalogEntity;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<CatalogEntity, Long> {
    CatalogEntity findByProductId(String productId);
}

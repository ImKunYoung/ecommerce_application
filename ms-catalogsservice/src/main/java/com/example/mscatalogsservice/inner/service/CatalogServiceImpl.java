package com.example.mscatalogsservice.inner.service;

import com.example.mscatalogsservice.outer.dto.CatalogDto;
import com.example.mscatalogsservice.inner.domain.CatalogEntity;
import com.example.mscatalogsservice.inner.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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

    @Override
    public CatalogDto getCatalogByProductId(String productId) {

        CatalogEntity catalogEntity = catalogRepository.findByProductId(productId);

        ModelMapper mapper = new ModelMapper();

        return mapper.map(catalogEntity, CatalogDto.class);

    }
}

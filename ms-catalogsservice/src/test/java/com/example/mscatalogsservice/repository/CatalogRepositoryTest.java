package com.example.mscatalogsservice.repository;

import com.example.mscatalogsservice.inner.domain.CatalogEntity;
import com.example.mscatalogsservice.inner.repository.CatalogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CatalogRepositoryTest {


    @Autowired
    private CatalogRepository catalogRepository;



    @Test
    void 게시글저장_불러오기() {

        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        CatalogEntity catalogEntity = CatalogEntity.builder()
                .productId("productId")
                .productName("productName")
                .stock(1)
                .unitPrice(1)
                .build();

        catalogRepository.save(catalogEntity);


        catalogRepository.findById(catalogEntity.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + catalogEntity.getId()));


    }



}

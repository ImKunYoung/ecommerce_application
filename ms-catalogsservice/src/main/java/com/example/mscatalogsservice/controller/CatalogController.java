package com.example.mscatalogsservice.controller;

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

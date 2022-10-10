package com.example.mscatalogsservice.controller;

import com.example.mscatalogsservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-catalogsservice")
@RequiredArgsConstructor
public class CatalogController {
    /*TODO: 32, r01-7*/


    private final Environment env;

    private final CatalogService catalogService;




}

package com.amefastforward.cardapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    //GET localhost::8080/card/health
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/health", produces = "application/json")
    public String health() {
        LOG.info("avaliando saúde da aplicação");
        return "{\"status\": \"OK\"}";
    }


}


//controller >> service >> repository >> model

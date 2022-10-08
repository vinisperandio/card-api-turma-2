package com.amefastforward.cardapi.controller;

import com.amefastforward.cardapi.controller.request.CreateCardRequest;
import com.amefastforward.cardapi.controller.request.UpdateCardRequest;
import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/card")
public class CardController {

    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //GET localhost:8080/card/{id}
    @GetMapping("{id}")
    public Card findCardById(@PathVariable("id") int id) {
        LOG.info("Iniciando busca pelo card com id [{}]", id);
        return cardService.findById(id);
    }

    //POST localhost:8080/card/
    @PostMapping
    public Card createCard(@RequestBody CreateCardRequest createCardRequest) {
        LOG.info("Iniciando criação de Card com nome [{}]", createCardRequest.getName());
        return cardService.createCard(createCardRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void deleteCard(@PathVariable("id") long id) {
        LOG.info("Deletando card com id [{}]", id);
        cardService.deleteCard(id);
    }

    @PutMapping("{id}")
    public Card updateCard(@PathVariable("id") long id, @RequestBody UpdateCardRequest updateCardRequest) {
        LOG.info("Atualizando card com id [{}]", id);
        return cardService.updateCard(id, updateCardRequest);
    }
}

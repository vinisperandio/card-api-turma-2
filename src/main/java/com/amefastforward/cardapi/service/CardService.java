package com.amefastforward.cardapi.service;

import com.amefastforward.cardapi.Repository.CardOriginRepository;
import com.amefastforward.cardapi.Repository.CardRepository;
import com.amefastforward.cardapi.controller.request.CreateCardRequest;
import com.amefastforward.cardapi.exception.EntityNotFoundException;
import com.amefastforward.cardapi.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardOriginRepository cardOriginRepository;

    @Autowired
    public CardService(CardRepository cardRepository, CardOriginRepository cardOriginRepository) {
        this.cardRepository = cardRepository;
        this.cardOriginRepository = cardOriginRepository;
    }

    public Optional<Card> findById(long id) {
        return cardRepository.findById(id);
    }

    public Card createCard(CreateCardRequest createCardRequest) {

        var origin = cardOriginRepository.findById(createCardRequest.getOriginId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Card origin de id [" + createCardRequest.getOriginId() + "] não encontrado")
                );

        var card = new Card();
        card.setName(createCardRequest.getName());
        card.setDescription(createCardRequest.getDescription());
        card.setStrength(createCardRequest.getStrength());
        card.setSpeed(createCardRequest.getSpeed());
        card.setSkill(createCardRequest.getSkill());
        card.setGear(createCardRequest.getGear());
        card.setIntellect(createCardRequest.getIntellect());
        card.setImageUrl(createCardRequest.getImageUrl());
        card.setOrigin(origin);
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        return cardRepository.save(card);
    }
}

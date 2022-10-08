package com.amefastforward.cardapi.service;

import com.amefastforward.cardapi.Repository.CardOriginRepository;
import com.amefastforward.cardapi.Repository.CardRepository;
import com.amefastforward.cardapi.controller.request.CreateCardRequest;
import com.amefastforward.cardapi.exception.EntityNotFoundException;
import com.amefastforward.cardapi.model.CardOrigin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CardServiceTest {

    @Mock
    CardRepository cardRepository;
    @Mock
    CardOriginRepository cardOriginRepository;

    @InjectMocks
    CardService cardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deveria retornar erro quando a carta não for encontrada")
    void shouldReturnErrorWhenCardNotFound() {
        when(cardRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> cardService.findById(0L));
    }

    @Test
    @DisplayName("Deveria criar uma carta com sucesso")
    void shouldSaveCardOnCreate() {
        var origin = new CardOrigin();
        when(cardOriginRepository.findById(any())).thenReturn(Optional.of(origin));
        when(cardRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        var cardRequest = new CreateCardRequest();
        cardRequest.setName("name");
        cardRequest.setDescription("description");
        cardRequest.setStrength(1);
        cardRequest.setSpeed(2);
        cardRequest.setSkill(3);
        cardRequest.setGear(4);
        cardRequest.setIntellect(5);
        cardRequest.setImageUrl("image_url");

        var card = cardService.createCard(cardRequest);

        assertEquals(card.getName(), cardRequest.getName());
        assertEquals(card.getSpeed(), cardRequest.getSpeed());
        assertEquals(card.getImageUrl(), cardRequest.getImageUrl());
    }
}
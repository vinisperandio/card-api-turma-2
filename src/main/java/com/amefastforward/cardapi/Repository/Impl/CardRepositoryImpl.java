package com.amefastforward.cardapi.Repository.Impl;

import com.amefastforward.cardapi.Repository.CardRepository;
import com.amefastforward.cardapi.model.Card;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cards;

    public CardRepositoryImpl() {
        cards = new ArrayList<>();

        var card = new Card();
        card.setId(1);
        card.setName("Iron Man");
        card.setDescription("Tony Stark");
        card.setStrength(5);
        card.setSpeed(7);
        card.setSkill(7);
        card.setGear(6);
        card.setIntellect(8);
        card.setImageUrl("url_image_iron_man");
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        cards.add(card);
    }

    @Override
    public Optional<Card> findById(int id) {
        return cards.stream()
                .filter(card -> card.getId() == id)
                .findFirst();
    }
}

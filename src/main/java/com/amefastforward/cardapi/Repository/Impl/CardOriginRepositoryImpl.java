package com.amefastforward.cardapi.Repository.Impl;

import com.amefastforward.cardapi.Repository.CardOriginRepository;
import com.amefastforward.cardapi.exception.InvalidEntityException;
import com.amefastforward.cardapi.model.CardOrigin;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardOriginRepositoryImpl implements CardOriginRepository {

    private final List<CardOrigin> cardOrigins = new ArrayList<>();

    @Override
    public Optional<CardOrigin> findById(int id) {
        return cardOrigins.stream()
                .filter(card -> card.getId() == id)
                .findFirst();
    }

    @Override
    public CardOrigin save(CardOrigin cardOrigin) {
        var cardOriginFound = cardOrigins.stream()
                .filter(storedCard -> storedCard.getName().equals(cardOrigin.getName()))
                .findFirst();

        if(cardOriginFound.isPresent()) {
            throw new InvalidEntityException("Card origin name [" + cardOrigin.getName() + "] already stored");
        }

        cardOrigin.setId(cardOrigins.size() + 1);
        cardOrigins.add(cardOrigin);

        return cardOrigin;
    }
}

package com.amefastforward.cardapi.Repository;

import com.amefastforward.cardapi.model.Card;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository {

    Optional<Card> findById(int id);

    Card save(Card card);
}

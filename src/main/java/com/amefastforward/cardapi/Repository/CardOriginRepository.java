package com.amefastforward.cardapi.Repository;

import com.amefastforward.cardapi.model.CardOrigin;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardOriginRepository {
    Optional<CardOrigin> findById(int id);

    CardOrigin save(CardOrigin cardOrigin);
}

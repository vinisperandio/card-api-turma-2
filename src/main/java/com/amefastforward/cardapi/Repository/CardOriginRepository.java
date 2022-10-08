package com.amefastforward.cardapi.Repository;

import com.amefastforward.cardapi.model.CardOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardOriginRepository extends JpaRepository<CardOrigin, Long> {}

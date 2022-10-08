package com.amefastforward.cardapi.Repository.Impl;

import com.amefastforward.cardapi.Repository.CardRepository;
import com.amefastforward.cardapi.exception.InvalidEntityException;
import com.amefastforward.cardapi.model.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private static final Logger LOG = LoggerFactory.getLogger(CardRepositoryImpl.class);
    private final ConnectionFactory connectionFactory;
    @Autowired
    public CardRepositoryImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Optional<Card> findById(int id) {
        String query = "SELECT * FROM card WHERE id = ?";

        try(Connection connection = connectionFactory.getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.execute();

                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    Card card = new Card();
                    card.setId(resultSet.getInt("id"));
                    card.setName(resultSet.getString("name"));
                    card.setDescription(resultSet.getString("description"));
                    card.setIntellect(resultSet.getInt("intellect"));
                    card.setGear(resultSet.getInt("gear"));
                    card.setSkill(resultSet.getInt("skill"));
                    card.setSpeed(resultSet.getInt("speed"));
                    card.setStrength(resultSet.getInt("strength"));
                    card.setImageUrl(resultSet.getString("image_url"));
                    card.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                    card.setUpdatedAt(resultSet.getTimestamp("updated_At").toLocalDateTime());

                    return Optional.of(card);
                }
            }

        } catch (SQLException e) {
            LOG.error("{}", e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Card save(Card card) {
        return new Card();
    }
}

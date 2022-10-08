package com.amefastforward.cardapi.Repository.Impl;

import com.amefastforward.cardapi.configuration.DatabaseConfig;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionFactory {

    private final DatabaseConfig databaseConfig;

    public ConnectionFactory(DatabaseConfig databaseConfig) { this.databaseConfig = databaseConfig; }

    public Connection getConnection() throws SQLException {
        var connection = DriverManager.getConnection(
                databaseConfig.getUrl(),
                databaseConfig.getUsername(),
                databaseConfig.getPassword()
        );

        connection.setAutoCommit(true);
        return connection;
    }
}

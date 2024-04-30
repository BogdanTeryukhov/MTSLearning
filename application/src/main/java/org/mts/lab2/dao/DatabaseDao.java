package org.mts.lab2.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

@Repository
public class DatabaseDao {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Connection getConnection(){
        try {
            return Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PreparedStatement prepare(Connection connection, String table) throws SQLException {
        return connection.prepareStatement(
                "SELECT * FROM animals." + table
        );
    }
}

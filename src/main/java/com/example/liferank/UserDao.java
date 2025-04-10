package com.example.liferank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insertar un nuevo usuario en la base de datos
    public void createUserDao(String name, int age) {
        String sql = "INSERT INTO users (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, age);
    }

    // Consultar usuarios de la base de datos (puedes agregar más consultas aquí)
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"))
        );
    }
}

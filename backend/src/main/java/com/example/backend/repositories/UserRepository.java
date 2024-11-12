package com.example.backend.repositories;

import com.example.backend.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private Sql2o sql2o;

    public List<UserEntity> findAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(UserEntity.class);
        }
    }

    public UserEntity findById(long id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(UserEntity.class);
        }
    }

    public UserEntity findByName(String name) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE name = :name")
                    .addParameter("name", name)
                    .executeAndFetchFirst(UserEntity.class);
        }
    }

    public UserEntity findByNameAndNotId(String name, int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE name = :name AND id != :id")
                    .addParameter("name", name)
                    .addParameter("id", id)
                    .executeAndFetchFirst(UserEntity.class);
        }
    }

    public UserEntity save(UserEntity clientEntity) {
        String query = "INSERT INTO users (name, password) " +
                "VALUES (:name, :password) RETURNING id";

        try (Connection con = sql2o.open()) {
            int id = con.createQuery(query, true)
                    .addParameter("name", clientEntity.getName())
                    .addParameter("password", clientEntity.getPassword())
                    .executeUpdate()
                    .getKey(Integer.class);

            clientEntity.setId(id);
            return clientEntity;
        }
    }

    public UserEntity update(UserEntity clientEntity) {
        String query = "UPDATE users SET name = :name, password = :password WHERE id = :id";

        try (Connection con = sql2o.open()) {
            con.createQuery(query)
                    .addParameter("name", clientEntity.getName())
                    .addParameter("password", clientEntity.getPassword())
                    .addParameter("id", clientEntity.getId())
                    .executeUpdate();

            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", clientEntity.getId())
                    .executeAndFetchFirst(UserEntity.class);

        }
    }

    public boolean delete(long id) {
        String query = "DELETE FROM users WHERE id = :id";

        try (Connection con = sql2o.open()) {
            int rowsSoftDeleted = con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getResult();
            return rowsSoftDeleted > 0;
        }
    }
}

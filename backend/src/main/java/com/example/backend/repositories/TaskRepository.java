package com.example.backend.repositories;

import com.example.backend.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    private Sql2o sql2o;

    public TaskEntity save(TaskEntity task) {
        String query = "INSERT INTO tasks (id_user, title, description, due_date) " +
                "VALUES (:id_user, :title, :description, :due_date) " +
                "RETURNING id";

        try (Connection con = sql2o.open()) {
            int id = con.createQuery(query, true)
                    .addParameter("id_user", task.getId_user())
                    .addParameter("title", task.getTitle())
                    .addParameter("description", task.getDescription())
                    .addParameter("due_date", task.getDue_date())
                    .executeUpdate()
                    .getKey(Integer.class);

            return con.createQuery("SELECT * FROM tasks WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TaskEntity.class);
        }
    }

    public List<TaskEntity> findTasksByUserID(int id_user) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM tasks WHERE id_user = :id_user")
                    .addParameter("id_user", id_user)
                    .executeAndFetch(TaskEntity.class);
        }
    }

    public List<TaskEntity> findTasksByUserIDAndStatusANDKeyword(int id_user, Boolean status, String keyword) {
        String query = "SELECT * FROM tasks WHERE id_user = :id_user AND status = :status " +
                "AND (title ILIKE :keyword OR description ILIKE :keyword)";

        try (Connection con = sql2o.open()) {
            String keywordWithWildcards = "%" + keyword + "%";

            return con.createQuery(query)
                    .addParameter("id_user", id_user)
                    .addParameter("status", status)
                    .addParameter("keyword", keywordWithWildcards)
                    .executeAndFetch(TaskEntity.class);
        }
    }

    public TaskEntity findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM tasks WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(TaskEntity.class);
        }
    }

    public TaskEntity update(TaskEntity task) {
        String query = "UPDATE tasks SET id_user = :id_user, title = :title, description = :description, due_date = :due_date, status = :status " +
                "WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(query)
                    .addParameter("id_user", task.getId_user())
                    .addParameter("title", task.getTitle())
                    .addParameter("description", task.getDescription())
                    .addParameter("due_date", task.getDue_date())
                    .addParameter("status", task.isStatus())
                    .addParameter("id", task.getId())
                    .executeUpdate();
            return con.createQuery("SELECT * FROM tasks WHERE id = :id")
                    .addParameter("id", task.getId())
                    .executeAndFetchFirst(TaskEntity.class);
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM tasks WHERE id = :id";
        try (Connection con = sql2o.open()) {
            int rowsDeleted = con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate()
                    .getResult();

            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

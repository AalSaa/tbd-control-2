-- Creación de la base de datos
CREATE DATABASE taskmanagementdb;

\c taskmanagementdb;

-- Creación de la tabla de usuarios
CREATE TABLE user (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Creación de la tabla de tareas
CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    id_user INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date DATE NOT NULL,
    status BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_user) REFERENCES usuario(id_user) ON DELETE CASCADE
);
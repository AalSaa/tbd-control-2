-- Creación de la base de datos
CREATE DATABASE taskmanagementdb;

\c taskmanagementdb;

-- Creación de la tabla de usuarios
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Creación de la tabla de tareas
CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    id_user INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date timestamp without time zone NOT NULL,
    status BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE
);
-- Creación de la base de datos
CREATE DATABASE taskmanagementdb;

\c taskmanagementdb;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS tasks CASCADE;

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

-- Población de la tabla de usuarios
INSERT INTO users (name, password) VALUES 
('alice', 'password123'),
('bob', 'secure456'),
('charlie', 'mypassword789'),
('sandra', 'contra123ma');

-- Población de la tabla de tareas

INSERT INTO tasks (id_user, title, description, due_date, status) VALUES 
(1, 'Tarea 1', 'Pedir cita al veterinario para Dorys mi gata', '2024-11-20 12:00:00', FALSE),
(1, 'Tarea 4', 'Organizar estudio para la universidad', '2024-12-04 12:00:00', TRUE),
(2, 'Tarea 2', 'Hacer limpieza completa en la casa', '2024-12-02 13:30:00', TRUE),
(3, 'Tarea 3', 'Comprar mercaderia en el supermercado', '2024-12-03 14:45:00', FALSE);
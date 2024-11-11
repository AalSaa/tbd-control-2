<template>
    <div class="container">
        <div>
            <h1>Modificar Tarea</h1>
            <form @submit.prevent="submitForm" class="form">
                <div>
                    <label for="title">Título:</label>
                    <input type="text" id="title" v-model="task.title" required>
                </div>
                <div>
                    <label for="description">Descripción:</label>
                    <textarea id="description" v-model="task.description" required></textarea>
                </div>
                <div>
                    <label for="dueDate">Fecha de Vencimiento:</label>
                    <input type="date" id="dueDate" v-model="task.dueDate" required>
                </div>
                <button type="submit">Modificar Tarea</button>
            </form>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

// Simulación de una tarea existente (esto debería venir de tu backend o estado global)
const existingTask = {
    title: 'Tarea de Ejemplo',
    description: 'Descripción de la tarea de ejemplo.',
    dueDate: '2024-12-31',
};

// Estado para la tarea que se va a editar
const task = ref({ ...existingTask });

const submitForm = () => {
    console.log('Tarea Modificada:', task.value);
    // Aquí puedes agregar la lógica para actualizar la tarea en tu backend o estado global
};
</script>

<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Altura completa de la ventana */
    background-color: #f4f4f4; /* Color de fondo suave */
}

.form {
    background-color: white; /* Fondo blanco para el formulario */
    border-radius: 8px; /* Bordes redondeados */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Sombra sutil */
    padding: 2rem; /* Espaciado interno */
    width: 400px; /* Ancho fijo para el formulario */
}

label {
    font-weight: bold;
}

input, textarea {
    padding: 0.5rem;
    font-size: 1rem;
    width: 100%; /* Ancho completo dentro del formulario */
}

button {
    padding: 0.5rem 1rem;
    font-size: 1rem;
    cursor: pointer;
    background-color: #007bff; /* Color del botón */
    color: white; /* Color del texto del botón */
    border: none; /* Sin borde */
    border-radius: 4px; /* Bordes redondeados del botón */
}

button:hover {
    background-color: #0056b3; /* Color más oscuro al pasar el mouse */
}
</style>
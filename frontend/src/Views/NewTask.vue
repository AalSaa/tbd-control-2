<template>
    <div class="container">
        <div class="form">
            <h1>Crear Nueva Tarea</h1>
            <form @submit.prevent="submitForm">
                <div>
                    <label for="title">Título:</label>
                    <input type="text" id="title" v-model="newTask.title" required>
                </div>
                <div>
                    <label for="description">Descripción:</label>
                    <textarea id="description" v-model="newTask.description" required></textarea>
                </div>
                <div>
                    <label for="dueDate">Fecha de Vencimiento:</label>
                    <input type="date" id="dueDate" v-model="newTask.due_date" required>
                </div>
                <button type="submit">Crear Tarea</button>
            </form>
        </div>
    </div>
</template>

<script setup>
import { reactive } from 'vue';
import { postTask } from '../services/TaskService.js';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';

const router = useRouter();
const store = useStore();
const user = computed(() => store.getters.getUser);

const newTask = reactive({
    id_user: user.value.user_id,
    title: '',
    description: '',
    due_date: '',
});

const submitForm = async () => {

    const response = await postTask(newTask);

    if (response.status === 201) {
        alert('Tarea creada correctamente');
        console.log('Nueva Tarea:', newTask);

        router.push({ name: 'ViewAllTasks' });
    } else {
        alert('Error al crear la tarea');
    }
};
</script>

<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    /* Altura completa de la ventana */
    background-color: #f4f4f4;
    /* Color de fondo suave */
}

.form {
    background-color: white;
    /* Fondo blanco para el formulario */
    border-radius: 8px;
    /* Bordes redondeados */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    /* Sombra sutil */
    padding: 2rem;
    /* Espaciado interno */
    width: 400px;
    /* Ancho fijo para el formulario */
}

label {
    font-weight: bold;
}

input,
textarea {
    padding: 0.5rem;
    font-size: 1rem;
    width: 100%;
    /* Ancho completo dentro del formulario */
}

button {
    padding: 0.5rem 1rem;
    font-size: 1rem;
    cursor: pointer;
    background-color: #007bff;
    /* Color del botón */
    color: white;
    /* Color del texto del botón */
    border: none;
    /* Sin borde */
    border-radius: 4px;
    /* Bordes redondeados del botón */
}

button:hover {
    background-color: #0056b3;
    /* Color más oscuro al pasar el mouse */
}
</style>
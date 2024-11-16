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
                    <input type="date" id="dueDate" v-model="task.due_date" required>
                </div>
                <button type="submit">Modificar Tarea</button>
            </form>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter, useRoute  } from 'vue-router';
import { getTaskById, updateTask } from '../services/TaskService.js';

const route = useRoute();
const router = useRouter();

const task = ref({
    id: '',
    title: '',
    description: '',
    due_date: '',
    completed: '',
});

// Función para obtener la tarea por ID
const fetchTask = async () => {
    const taskId = route.params.id; // Obtener el ID de la tarea desde la URL
    console.log('Cargando tarea con ID:', taskId);
    const response = await getTaskById(taskId);
    response.data.due_date = response.data.due_date.split('T')[0]; // Formatear la fecha
    console.log('Respuesta:', response);
    task.value = response.data; // Asignar la respuesta a la variable task
};

// Llamar a fetchTask cuando el componente se monta
onMounted(() => {
    fetchTask();
});


const submitForm = async () => {
    task.value.due_date = task.value.due_date.split('T')[0];
    const response = await updateTask(task.value);
    console.log('Response:', response);
    router.push({ name: 'ViewTask', params: { id: task.value.id } });

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
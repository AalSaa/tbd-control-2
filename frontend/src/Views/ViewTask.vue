<template>
    <div class="container">
        <h1>Tarea: {{ task.title }}</h1>
        <div class="task-details" v-if="task">
            <p><strong>Descripción:</strong> {{ task.description }}</p>
            <p><strong>Fecha Límite:</strong> {{ task.due_date }}</p>
            <p><strong>Estado:</strong> {{ task.status ? 'Completada' : 'Pendiente' }}</p>
        </div>
        <div class="button-group">
            <button @click="editTask">Editar</button>
            <button @click="deleteTaskButton">Eliminar</button>
            <button @click="markAsCompleted" :class="{ completed: task.status }">
                {{ task.completed ? 'Completada' : 'Marcar como Completada' }}
            </button>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { getTaskById, updateTask, deleteTask } from '../services/TaskService.js';

const router = useRouter();
const route = useRoute();

const task = ref({
    id: '',
    title: '',
    description: '',
    due_date: '',
    status: '',
});


const fetchTask = async () => {
    const taskId = route.params.id; // Obtener el ID de la tarea desde la URL
    console.log('Cargando tarea con ID:', taskId);
    const response = await getTaskById(taskId);
    response.data.due_date = response.data.due_date.split('T')[0];
    console.log('Respuesta:', response);
    task.value = response.data; 
};


onMounted(() => {
    fetchTask();
});


const editTask = () => {
    console.log('Editar tarea:', task.value);       
    router.push({ name: 'EditTask', params: { id: task.value.id } });
};

const deleteTaskButton = async () => {
    console.log('Eliminando tarea:', task.value);
    const response = await deleteTask(task.value.id);
    router.push({name: 'NewTask'})
};

const markAsCompleted = async () => {
    task.value.status = true;
    const response = await updateTask(task.value);   
}

</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Altura completa de la ventana */
    background-color: #f4f4f4; /* Color de fondo suave */
}

.task-details {
    background-color: white; /* Fondo blanco para los detalles */
    border-radius: 8px; /* Bordes redondeados */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Sombra sutil */
    padding: 2rem; /* Espaciado interno */
    width: 400px; /* Ancho fijo para los detalles */
}

.button-group {
    margin-top: 1rem; /* Espacio entre los detalles y los botones */
}

button {
    padding: 0.5rem 1rem;
    font-size: 1rem;
    cursor: pointer;
    background-color: #007bff; /* Color del botón */
    color: white; /* Color del texto del botón */
    border: none; /* Sin borde */
    border-radius: 4px; /* Bordes redondeados del botón */
    margin-right: 0.5rem; /* Espacio entre botones */
}

button:hover {
    background-color: #0056b3; /* Color más oscuro al pasar el mouse */
}

.completed {
    background-color: #28a745; /* Color verde para el botón completado */
}
</style>
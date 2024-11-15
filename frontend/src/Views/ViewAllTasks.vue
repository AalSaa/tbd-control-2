<template>
    <div class="container">
        <input class="search" type="text" placeholder="Buscar tareas">
        <div class="tasks">
            <div v-for="task in tasks" :key="task.id">
                <div class="task">
                    <h2>{{ task.title }}</h2>
                    <p>{{ task.description }}</p>
                    <p>Fecha de vencimiento: {{ task.due_date }}</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script setup>
import { getAllTasks } from '../services/TaskService.js';
import { onMounted, ref } from 'vue';

const tasks = ref([]);

const getTasks = async () => {
    const response = await getAllTasks(1);

    if (response.status === 200) {
        console.log("Tareas obtenidas:", response.data);
        tasks.value = response.data;
    } else {
        alert("Error al obtener las tareas");
    }
}

onMounted(getTasks);

</script>
<style>
.search {
    margin: 10px;
    padding: 0.5rem;
    font-size: 1rem;
    width: 20%;
}

.tasks {
    display: flex;
    flex-wrap: wrap;
    height: 100vh;
    background-color: #f4f4f4;
}

.task {
    margin: 10px;
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    padding: 1rem;
    width: 400px;
}
</style>
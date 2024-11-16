<template>
    <div class="container">
        <div class="search-bar">
            <input class="search" type="text" placeholder="Buscar tareas" v-model="keyword">
            <select v-model="status" class="status-select">
                <option value="0">No completadas</option>
                <option value="1">Completadas</option>
            </select>
            <button class="btn primary-btn" v-on:click="TasksbyFilters()">Buscar</button>
            <button class="btn secondary-btn" v-on:click="verifyDueDateToAllTasks()">Verificar vencimientos</button>
        </div>
        <div class="tasks">
            <div v-for="task in tasks" :key="task.id" class="task-card">
                <h2>{{ task.title }}</h2>
                <p>{{ task.description }}</p>
                <p>Fecha de vencimiento: {{ task.due_date.split('T')[0] }}</p>
                <button class="btn primary-btn" v-on:click="goViewTasks(task.id)">Acciones para tarea </button>
            </div>
        </div>
    
    </div>
</template>

<script setup>
import { getAllTasks, getTasksbyFilters } from '../services/TaskService.js';
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';

const dueTasks = ref([]);
const tasks = ref([]);
const keyword = ref('');
const status = ref(0);
const router = useRouter();

const getTomorrowDate = () => {
    const today = new Date();
    const tomorrow = new Date(today);
    tomorrow.setDate(today.getDate() + 1);
    return tomorrow.toISOString().split('T')[0];
};

const verifyDueDateToAllTasks = () => {
    const tomorrow = getTomorrowDate();
    dueTasks.value = [];
    let tasksDueTomorrow = tasks.value.filter(task => task.due_date === tomorrow);

    if (tasksDueTomorrow.length > 0) {
        dueTasks.value = tasksDueTomorrow;
        const taskTitles = dueTasks.value.map(task => task.title).join(', ');
        alert(`Las siguientes tareas vencen mañana: ${taskTitles}`);
    } else {
        alert("No hay tareas que venzan mañana.");
    }
};

const TasksbyFilters = async () => {
    const response = await getTasksbyFilters(1, keyword.value, status.value);

    if (response.status === 200) {
        tasks.value = response.data;
    } else {
        alert("Error al obtener las tareas");
    }
};

const getTasks = async () => {
    const response = await getAllTasks(1);

    if (response.status === 200) {
        
        tasks.value = response.data;
    } else {
        alert("Error al obtener las tareas");
    }
};

const goViewTasks = (task_id) => {
    console.log('Ver tarea' + task_id);
    router.push({ name: 'ViewTask', params: { id: task_id } });
};

onMounted(() => {
    getTasks();
});
</script>

<style scoped>
.container {
    padding: 20px;
}

.search-bar {
    display: flex;
    gap: 10px;
    margin-bottom: 20px;
}

.search,
.status-select,
.btn {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

.btn {
    cursor: pointer;
}

.primary-btn {
    background-color: #007bff;
    color: white;
}

.secondary-btn {
    background-color: #6c757d;
    color: white;
}

.tasks {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
}

.task-card {
    background-color: white;
    padding: 15px;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    width: calc(33.333% - 20px);
}
</style>
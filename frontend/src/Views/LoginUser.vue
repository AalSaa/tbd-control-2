<template>
    <div class="login-container">
        <h1>Iniciar Sesión</h1>
        <form @submit.prevent="login">
            <div>
                <label for="email">Email:</label>
                <input type="email" v-model="userData.email" required />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" v-model="userData.password" required />
            </div>
            <button type="submit">Iniciar Sesión</button>
        </form>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { loginUser } from '../services/UserService.js';

const userData = ref({ email: '', password: '' });

const login = async () => {
    const response = await loginUser(userData.value);
    console.log('Response:', response);
    if (response.status === 200) {
        alert('Sesión iniciada correctamente');
    } else {
        alert('Error al iniciar sesión');
    }
};
</script>

<style scoped>
.login-container {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

h1 {
    text-align: center;
}

form div {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 5px;
}

input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #0056b3;
}
</style>

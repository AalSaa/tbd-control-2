<template>
    <div class="register-container">
        <h1>Registro de Nuevo Usuario</h1>
        <form @submit.prevent="registerUser">
            <div>
                <label for="name">Nombre:</label>
                <input type="text" id="name" v-model="userData.name" placeholder="Ingrese su nombre" required />
            </div>
            <div>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" v-model="userData.password" placeholder="Ingrese su contraseña"
                    required />
            </div>
            <button type="submit">Registrar</button>
        </form>
    </div>
</template>

<script setup>
import { reactive } from 'vue';
import { postClient } from '../services/UserService.js';

const userData = reactive({
    name: '',
    password: '',
});

const registerUser = async () => {
    const response = await postClient(userData);
    if (response.status === 201) {
        alert('Usuario registrado correctamente');
    } else {
        alert('Error al registrar el usuario');
    }
};
</script>

<style scoped>
.register-container {
    max-width: 400px;
    margin: 0 auto;
    /* Centra el contenedor */
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

h1 {
    text-align: center;
    /* Centra el texto del título */
    color: green;
}

form div {
    margin-bottom: 15px;
    /* Espaciado entre los campos */
}

label {
    display: block;
    /* Asegura que las etiquetas estén en línea separada */
    margin-bottom: 5px;
    /* Espaciado entre la etiqueta y el campo */
}

input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
    /* Incluye padding en el ancho total */
}

button {
    width: 100%;
    padding: 10px;
    background-color: green;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: darkgreen;
}
</style>
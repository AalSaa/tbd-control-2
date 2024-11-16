<template>
    <section class="nav-bar">
        <div class="nav-links">
            <div class="nav-links-task">
                <RouterLink class="nav-link-newtask" to="/newtask">
                    New Tasks
                </RouterLink>
                <RouterLink class="nav-link-alltasks" to="/viewalltasks">
                    All Tasks
                </RouterLink>
            </div>

            <RouterLink v-if="!login" class="nav-link-login" to="/">
                Login
            </RouterLink>
            <RouterLink v-else class="nav-link-login" v-on:click="logout()" to="/">
                Logout
            </RouterLink>
            <RouterLink class="nav-link-register" to="/register">
                Register
            </RouterLink>
        </div>
    </section>
</template>
<script setup>
import { RouterLink } from 'vue-router';
import httpClient from '../Utils/http-common';
import { ref } from 'vue';

const login = ref(false);

const logout = async () => {
    const response = await httpClient.post("/auth/logout", {
        withCredentials: true,
    });

    if (response.status === 200) {
        alert("Usuario desconectado");
    } else {
        alert("Error al desconectar");
    }
}

</script>
<style>
.nav-links-task {
    display: flex;
    align-items: center;
    justify-content: start;
    flex-grow: 1;
    margin-right: 1rem;
    text-decoration: none;
    font-weight: bold;
    padding: 0.5rem 1rem;
    border-radius: 5px;
    margin-right: 1rem;
    text-decoration: none;
}

.nav-link-newtask {
    text-decoration: none;
    color: rgb(0, 0, 0);
    font-weight: bold;
    border: 1px solid rgb(0, 0, 0);
    padding: 0.5rem 1rem;
    border-radius: 5px;
}

.nav-link-alltasks {
    text-decoration: none;
    color: rgb(0, 0, 0);
    font-weight: bold;
    border: 1px solid rgb(0, 0, 0);
    padding: 0.5rem 1rem;
    border-radius: 5px;
}

.nav-bar {
    display: flex;
    align-items: center;
    padding: 1rem;
    background-color: rgb(255, 255, 255);
    border-bottom: 1px solid rgb(230, 230, 230);
    margin-bottom: 1rem;
}

.nav-link-login {
    margin-right: 1rem;
    text-decoration: none;
    color: rgb(0, 0, 0);
    font-weight: bold;
    border: 1px solid rgb(0, 0, 0);
    padding: 0.5rem 1rem;
    border-radius: 5px;
}

.nav-link-register {
    text-decoration: none;
    color: rgb(0, 0, 0);
    font-weight: bold;
    border: 1px solid rgb(0, 0, 0);
    padding: 0.5rem 1rem;
    border-radius: 5px;
}

.nav-links {
    display: flex;
    align-items: center;
    justify-content: end;
    flex-grow: 1;
    margin-right: 1rem;
}

.nav-link-logout {
    text-decoration: none;
    color: rgb(0, 0, 0);
    font-weight: bold;
    border: 1px solid rgb(0, 0, 0);
    padding: 0.5rem 1rem;
    border-radius: 5px;
}
</style>
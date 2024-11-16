<template>
    <section class="nav-bar">
        <div class="nav-links">
            <div v-if="loginState" class="nav-links-task">
                <RouterLink class="nav-link-newtask nav-link-button" to="/newtask">
                    Tasks
                </RouterLink>
                <RouterLink class="nav-link-alltasks nav-link-button" to="/viewalltasks">
                    All Tasks
                </RouterLink>
            </div>

            <RouterLink v-if="loginState" class="nav-link-logout nav-link-button" v-on:click="logout()" to="/">
                Logout
            </RouterLink>

            <div class="nav-link-login-register" v-else>
                <RouterLink class="nav-link-login nav-link-button" to="/">
                    Login
                </RouterLink>

                <RouterLink class="nav-link-register nav-link-button" to="/register">
                    Register
                </RouterLink>
            </div>
        </div>
    </section>
</template>

<script setup>
import { RouterLink } from 'vue-router';
import { useStore } from 'vuex';
import httpClient from '../Utils/http-common';
import { computed } from 'vue';

const store = useStore();
const loginState = computed(() => store.getters.getLogin);

const logout = async () => {
    const response = await httpClient.post("/auth/logout", {
        withCredentials: true,
    });

    if (response.status === 200) {
        alert("Usuario desconectado");
        store.commit("logout");
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
}

.nav-bar {
    display: flex;
    align-items: center;
    padding: 1rem;
    background-color: rgb(255, 255, 255);
    border-bottom: 1px solid rgb(230, 230, 230);
    margin-bottom: 1rem;
}

.nav-links {
    display: flex;
    align-items: center;
    justify-content: end;
    flex-grow: 1;
    margin-right: 1rem;
}

.nav-link-button {
    text-decoration: none;
    color: rgb(0, 0, 0);
    font-weight: bold;
    border: 1px solid rgb(0, 0, 0);
    padding: 0.5rem 1rem;
    border-radius: 5px;
}

.nav-link-login-register {
    padding: 0.5rem 1rem;
}
</style>
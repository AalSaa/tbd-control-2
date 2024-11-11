<template>
    <section class="nav-bar">
        <div class="nav-links">
            <RouterLink class="nav-link-login" to="/">
                Login
            </RouterLink>
            <RouterLink class="nav-link-register" to="/register">
                Register
            </RouterLink>
        </div>
    </section>
</template>
<script setup>
import { RouterLink } from 'vue-router';

</script>
<style>
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
</style>
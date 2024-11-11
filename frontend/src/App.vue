<script setup>
import { RouterView } from 'vue-router';
import NavBar from './components/NavBar.vue';
</script>

<template>
  <div class="mt-14">
    <NavBar />
    <div>
      <RouterView />
    </div>
  </div>
</template>

<style scoped></style>

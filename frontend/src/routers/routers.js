import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/LoginUser.vue";
import Register from "../views/RegisterUser.vue";

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/register",
    name: "Register",
    component: Register,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes, // Aquí pasas el array routes directamente
  linkActiveClass: "active-link",
});

export default router;

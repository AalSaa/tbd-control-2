import { createRouter, createWebHistory } from "vue-router";
import Login from "../Views/LoginUser.vue";
import Register from "../Views/RegisterUser.vue";
import newtask from "../Views/NewTask.vue";
import EditTask from "../Views/EditTask.vue";
import ViewTask from "../Views/ViewTask.vue";

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
  {
    path: "/newtask",
    name: "NewTask",
    component: newtask,
  },
  {
    path: "/edittask",
    name: "EditTask",
    component: EditTask,
  },
  {
    path: "/viewtask",
    name: "ViewTask",
    component: ViewTask,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes, // Aquí pasas el array routes directamente
  linkActiveClass: "active-link",
});

export default router;

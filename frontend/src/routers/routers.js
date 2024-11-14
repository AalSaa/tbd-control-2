import { createRouter, createWebHistory } from "vue-router";
import { auth } from "../Utils/AuthGuard";
import Login from "../Views/LoginUser.vue";
import Register from "../Views/RegisterUser.vue";
import NewTask from "../Views/NewTask.vue";
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
    component: NewTask,
    //beforeEnter: auth,
  },
  {
    path: "/edittask/:id",
    name: "EditTask",
    component: EditTask,
    //beforeEnter: auth,
  },
  {
    path: "/viewtask/:id",
    name: "ViewTask",
    component: ViewTask,
    //beforeEnter: auth,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;

import { createApp } from "vue";
import App from "./App.vue";
import router from "./routers/routers";
import VueCookies from "vue3-cookies"; // Importa la librería vue3-cookies
import store from "./store/Store.js";

// Crea la aplicación Vue y registra vue3-cookies y el router
createApp(App)
  .use(router)
  .use(VueCookies) // Usa vue3-cookies en la aplicación
  .use(store)
  .mount("#app");

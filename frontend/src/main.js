import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/index"; // Asegúrate de que esté importado
import { createPinia } from "pinia";
import "./assets/css/main.css"; 

const app = createApp(App);
app.use(createPinia());
app.use(router); // 📌 Se registra el router en la app
app.mount("#app");

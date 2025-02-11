import { createRouter, createWebHistory } from "vue-router";
import { useAuthStore } from "../store/authStore";
import Home from "../pages/Home.vue";
import Login from "../pages/Login.vue";
import Dashboard from "../pages/Dashboard.vue";
import CursoDetalle from "../pages/CursoDetalle.vue";
import Foro from "../pages/Foro.vue";
import Perfil from "../pages/Perfil.vue";
import Settings from "../pages/Settings.vue";

const routes = [
  { path: "/", component: Home },
  { path: "/login", component: Login },
  { path: "/dashboard", component: Dashboard, meta: { requiresAuth: true } },
  { path: "/curso/:id", component: CursoDetalle, meta: { requiresAuth: true } },
  { path: "/foro", component: Foro, meta: { requiresAuth: true } },
  { path: "/perfil", component: Perfil, meta: { requiresAuth: true } },
  { path: "/settings", component: Settings },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  console.log("Navegando a:", to.path); // Debug para ver cambios de ruta

  const authStore = useAuthStore();
  const isAuthenticated = !!authStore.token; // Verifica si hay sesión activa

  if (to.meta.requiresAuth && !isAuthenticated) {
    console.warn("Acceso restringido. Redirigiendo a login.");
    next("/login");
  } else {
    next();
  }
});

export default router;

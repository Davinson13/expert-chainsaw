<script setup>
import { ref, watchEffect, onMounted } from "vue";
import { useAuthStore } from "../store/authStore";

const authStore = useAuthStore();
const darkMode = ref(false);

// Verifica el modo oscuro almacenado
onMounted(() => {
  darkMode.value = localStorage.getItem("darkMode") === "true";
  document.documentElement.classList.toggle("dark", darkMode.value);
});

const toggleDarkMode = () => {
  darkMode.value = !darkMode.value;
  localStorage.setItem("darkMode", darkMode.value);
  document.documentElement.classList.toggle("dark", darkMode.value);
};

const logout = () => {
  authStore.logoutUser();
  window.location.href = "/login";
};

watchEffect(() => {
  document.documentElement.classList.toggle("dark", darkMode.value);
});
</script>

<template>
  <div class="container mx-auto px-4 py-6">
    <h2 class="text-3xl font-bold mb-4 text-gray-900 dark:text-white">Ajustes</h2>

    <div class="bg-white dark:bg-gray-800 shadow-md rounded-lg p-6">
      <!-- Alternar Modo Oscuro -->
      <div class="flex items-center justify-between mb-4">
        <p class="font-semibold text-gray-800 dark:text-gray-200">Modo Oscuro</p>
        <button @click="toggleDarkMode" 
          class="px-4 py-2 rounded transition duration-300"
          :class="darkMode ? 'bg-yellow-500 text-gray-900' : 'bg-gray-700 text-white hover:bg-gray-600'">
          {{ darkMode ? "Desactivar" : "Activar" }}
        </button>
      </div>

      <hr class="my-4 border-gray-300 dark:border-gray-600">

      <button @click="logout" 
        class="w-full bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 transition duration-300">
        Cerrar Sesión
      </button>
    </div>
  </div>
</template>
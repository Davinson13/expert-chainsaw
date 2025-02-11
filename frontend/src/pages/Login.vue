<template>
  <div class="flex items-center justify-center min-h-screen bg-gray-100">
    <div class="bg-white p-6 rounded-lg shadow-md w-96">
      <h2 class="text-2xl font-bold mb-4 text-center">Iniciar Sesión</h2>
      <input v-model="email" type="email" placeholder="Correo electrónico" class="w-full border p-2 rounded mb-2">
      <input v-model="password" type="password" placeholder="Contraseña" class="w-full border p-2 rounded mb-2">
      <button @click="handleLogin" class="w-full bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
        Ingresar
      </button>
      <p v-if="error" class="text-red-500 text-sm mt-2">{{ error }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useAuthStore } from "../store/authStore";
import { useRouter } from "vue-router";

const email = ref("");
const password = ref("");
const error = ref("");
const authStore = useAuthStore();
const router = useRouter();

const handleLogin = async () => {
  try {
    await authStore.loginUser(email.value, password.value);
    router.push("/dashboard"); // Redirige al Dashboard
  } catch (err) {
    error.value = "Correo o contraseña incorrectos";
  }
};
</script>

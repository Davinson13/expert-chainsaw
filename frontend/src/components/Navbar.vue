<template>
  <nav class="bg-gray-900 text-white px-6 py-4 flex justify-between items-center">
    <h1 class="text-xl font-bold">Educación Online</h1>
    <ul class="hidden md:flex gap-6">
      <li><router-link to="/" class="hover:text-blue-400">Inicio</router-link></li>
      <li><router-link to="/dashboard" class="hover:text-blue-400">Mis Cursos</router-link></li>
      <li><router-link to="/foro" class="hover:text-blue-400">Foro</router-link></li>
    </ul>
    <button @click="toggleMenu" class="md:hidden">
      <MenuIcon class="w-6 h-6" />
    </button>
  </nav>
</template>

<script setup>
import { ref } from "vue";
import { Bars3Icon } from "@heroicons/vue/24/solid"; // ✅ Nombre correcto

const isOpen = ref(false);
const toggleMenu = () => (isOpen.value = !isOpen.value);
</script>

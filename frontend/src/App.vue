<script setup>
import Navbar from './components/Navbar.vue'
import Sidebar from './components/Sidebar.vue'
</script>

<template>
  <div class="flex h-screen">
    <!-- Barra lateral -->
    <Sidebar class="w-1/5 bg-gray-100 p-4" />
    
    <!-- Contenido principal -->
    <div class="flex-1 flex flex-col">
      <Navbar class="bg-blue-600 text-white p-4" />
      
      <!-- Aquí se cargarán las páginas dinámicamente -->
      <div class="p-6">
        <p>Contenido de la página:</p>
        <router-view />
      </div>
    </div>
  </div>
</template>

<style scoped>
</style>

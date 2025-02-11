<template>
    <div class="fixed top-4 right-4 w-80 bg-white shadow-md rounded-lg p-4">
      <h3 class="text-lg font-bold">Notificaciones</h3>
      <ul>
        <li v-for="notif in notificaciones" :key="notif.id" class="p-2 border-b last:border-b-0">
          {{ notif.mensaje }}
        </li>
      </ul>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from "vue";
  import { iniciarWebSocket } from "../services/websocketService";
  
  const notificaciones = ref([]);
  
  onMounted(() => {
    iniciarWebSocket((mensaje) => {
      notificaciones.value.push({ id: Date.now(), mensaje });
    });
  });
  </script>
  
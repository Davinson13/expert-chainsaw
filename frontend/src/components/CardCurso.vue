<template>
  <div class="bg-white shadow-lg rounded-lg overflow-hidden">
    <img :src="curso.imagen" alt="Curso" class="w-full h-48 object-cover">
    <div class="p-4">
      <h3 class="text-lg font-bold">{{ curso.nombre }}</h3>
      <button class="mt-4 bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
        Ver Curso
      </button>
    </div>
  </div>
</template>

<script setup>
defineProps({ curso: Object });
</script>

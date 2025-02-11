<template>
  <div class="container mx-auto px-4 py-6">
    <!-- Cargando -->
    <div v-if="loading" class="text-center text-lg font-semibold">Cargando curso...</div>

    <template v-else>
      <h2 class="text-3xl font-bold mb-4">{{ curso.nombre }}</h2>

      <!-- Sección de Video -->
      <div class="bg-gray-900 rounded-lg overflow-hidden shadow-md">
        <iframe
          v-if="curso.videoUrl"
          class="w-full h-64 md:h-96"
          :src="curso.videoUrl"
          frameborder="0"
          allowfullscreen
        ></iframe>
        <p v-else class="text-white text-center p-4">Este curso no tiene video disponible.</p>
      </div>

      <!-- Módulos del Curso -->
      <h3 class="text-2xl font-semibold mt-6 mb-3">Módulos</h3>
      <div class="border border-gray-300 rounded-lg p-4">
        <ul>
          <li
            v-for="modulo in curso.modulos"
            :key="modulo.id"
            class="p-2 border-b last:border-b-0 hover:bg-gray-100 cursor-pointer"
          >
            📖 {{ modulo.titulo }}
          </li>
        </ul>
      </div>
    </template>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { getCursoDetalle } from "../services/cursoService";

const route = useRoute();
const curso = ref({ nombre: "", videoUrl: "", modulos: [] });
const loading = ref(true);

onMounted(async () => {
  try {
    curso.value = await getCursoDetalle(route.params.id);
  } catch (error) {
    console.error("Error al obtener curso:", error);
  } finally {
    loading.value = false;
  }
});
</script>

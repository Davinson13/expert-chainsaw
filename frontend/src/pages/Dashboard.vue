<template>
  <div class="container mx-auto px-4 py-6">
    <h2 class="text-3xl font-bold my-6">Mis Cursos</h2>

    <!-- Estado de carga -->
    <div v-if="loading" class="text-center text-lg font-semibold">Cargando cursos...</div>

    <div v-else-if="cursos.length > 0" class="grid grid-cols-1 md:grid-cols-3 gap-6">
      <CardCurso v-for="curso in cursos" :key="curso.id" :curso="curso" />
    </div>

    <div v-else class="text-center text-lg text-gray-600">No estás inscrito en ningún curso aún.</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import CardCurso from "../components/CardCurso.vue";
import { getMisCursos } from "../services/cursoService";

const cursos = ref([]);
const loading = ref(true);

onMounted(async () => {
  try {
    cursos.value = await getMisCursos();
  } catch (error) {
    console.error("Error al cargar cursos:", error);
  } finally {
    loading.value = false;
  }
});
</script>


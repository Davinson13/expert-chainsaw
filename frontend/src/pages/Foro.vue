<template>
    <div class="container mx-auto px-4 py-6">
      <h2 class="text-3xl font-bold mb-4">Foro de Discusión</h2>
  
      <!-- Estado de carga -->
      <div v-if="loading" class="text-center text-lg font-semibold">Cargando comentarios...</div>
  
      <template v-else>
        <!-- Formulario para Crear un Comentario -->
        <div class="bg-white shadow-md rounded-lg p-4 mb-6">
          <textarea
            v-model="nuevoComentario"
            placeholder="Escribe tu comentario..."
            class="w-full border p-2 rounded resize-none"
          ></textarea>
          <button
            @click="publicarComentario"
            class="mt-2 bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
          >
            Publicar
          </button>
        </div>
  
        <!-- Lista de Comentarios -->
        <div class="bg-gray-100 p-4 rounded-lg">
          <h3 class="text-xl font-semibold mb-2">Comentarios</h3>
          <ul>
            <li
              v-for="comentario in comentarios"
              :key="comentario.id"
              class="border-b last:border-b-0 p-3 transition hover:bg-gray-200"
            >
              <p class="font-semibold">{{ comentario.autor }}</p>
              <p class="text-gray-700">{{ comentario.mensaje }}</p>
            </li>
          </ul>
        </div>
      </template>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from "vue";
  import { getComentarios, agregarComentario } from "../services/foroService";
  
  const comentarios = ref([]);
  const nuevoComentario = ref("");
  const loading = ref(true);
  
  const publicarComentario = async () => {
    if (!nuevoComentario.value.trim()) return;
    await agregarComentario({ mensaje: nuevoComentario.value });
    nuevoComentario.value = "";
    comentarios.value = await getComentarios();
  };
  
  onMounted(async () => {
    try {
      comentarios.value = await getComentarios();
    } catch (error) {
      console.error("Error al cargar comentarios:", error);
    } finally {
      loading.value = false;
    }
  });
  </script>
  
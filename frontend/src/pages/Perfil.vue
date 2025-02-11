<template>
    <div class="container mx-auto px-4 py-6">
      <h2 class="text-3xl font-bold mb-4">Mi Perfil</h2>
  
      <div class="bg-white shadow-md rounded-lg p-6">
        <!-- Foto de perfil -->
        <div class="flex items-center gap-4">
          <img :src="usuario.avatar" alt="Foto de perfil" class="w-16 h-16 rounded-full border">
          <input type="file" @change="actualizarFoto" accept="image/*">
        </div>
  
        <!-- Datos del usuario -->
        <div class="mt-4">
          <label class="block font-semibold">Nombre:</label>
          <input v-model="usuario.nombre" class="w-full border p-2 rounded">
        </div>
  
        <div class="mt-4">
          <label class="block font-semibold">Correo electrónico:</label>
          <input v-model="usuario.email" class="w-full border p-2 rounded" disabled>
        </div>
  
        <!-- Cambio de contraseña -->
        <div class="mt-4">
          <label class="block font-semibold">Nueva Contraseña:</label>
          <input v-model="nuevaContrasena" type="password" class="w-full border p-2 rounded">
        </div>
  
        <button @click="guardarCambios" class="mt-4 bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">
          Guardar Cambios
        </button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from "vue";
  import { getPerfil, actualizarPerfil } from "../services/userService";
  
  const usuario = ref({ nombre: "", email: "", avatar: "" });
  const nuevaContrasena = ref("");
  
  onMounted(async () => {
    usuario.value = await getPerfil();
  });
  
  const actualizarFoto = (event) => {
    const archivo = event.target.files[0];
    if (archivo) {
      usuario.value.avatar = URL.createObjectURL(archivo);
    }
  };
  
  const guardarCambios = async () => {
    await actualizarPerfil({ ...usuario.value, nuevaContrasena: nuevaContrasena.value });
    alert("Perfil actualizado con éxito");
  };
  </script>
  
<template>
  <div class="w-64 h-screen bg-gray-800 text-white fixed">
    <h2 class="text-xl font-bold p-4">Menú</h2>
    <ul class="space-y-2 p-4">
      <li>
        <router-link to="/dashboard" class="block p-2 rounded hover:bg-gray-700" exact-active-class="bg-gray-700">📚 Mis Cursos</router-link>
      </li>
      <li>
        <router-link to="/foro" class="block p-2 rounded hover:bg-gray-700" exact-active-class="bg-gray-700">💬 Foro</router-link>
      </li>
      <li>
        <router-link to="/perfil" class="block p-2 rounded hover:bg-gray-700" exact-active-class="bg-gray-700">👤 Perfil</router-link>
      </li>
      <li>
        <router-link to="/settings" class="block p-2 rounded hover:bg-gray-700" exact-active-class="bg-gray-700">⚙️ Configuración</router-link>
      </li>
    </ul>
  </div>
</template>

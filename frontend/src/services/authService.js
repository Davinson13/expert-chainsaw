import api from "./api";
import { defineStore } from "pinia";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    user: null,
    token: localStorage.getItem("token") || "",
  }),
  actions: {
    async loginUser(email, password) {
      const data = await login(email, password);
      this.token = data.token;
      localStorage.setItem("token", this.token);
      this.user = { email }; // Simulación de usuario autenticado
    },
    logoutUser() {
      this.token = "";
      this.user = null;
      localStorage.removeItem("token");
    },
  },
});

export const login = async (email, password) => {
  const response = await api.post("/auth/login", { email, password });
  localStorage.setItem("token", response.data.token);
  return response.data;
};

export const logout = () => {
  localStorage.removeItem("token");
};
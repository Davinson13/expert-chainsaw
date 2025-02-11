import { defineStore } from "pinia";
import { login } from "../services/authService";

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
    },
    logoutUser() {
      this.token = "";
      localStorage.removeItem("token");
    },
  },
});

import api from "./api";

export const getPerfil = async () => {
  const response = await api.get("/usuario/perfil", {
    headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
  });
  return response.data;
};

export const actualizarPerfil = async (datos) => {
  await api.put("/usuario/perfil", datos, {
    headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
  });
};

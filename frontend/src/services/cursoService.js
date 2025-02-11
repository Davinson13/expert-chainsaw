import api from "./api";

export const getCursos = async () => {
  const response = await api.get("/cursos");
  return response.data;
};

export const getMisCursos = async () => {
  const response = await api.get("/cursos/mis-cursos", {
    headers: { Authorization: `Bearer ${localStorage.getItem("token")}` },
  });
  return response.data;
};

export const getCursoDetalle = async (id) => {
  const response = await api.get(`/cursos/${id}`);
  return response.data;
};

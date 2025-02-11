import api from "./api";

export const getComentarios = async () => {
  const response = await api.get("/foro");
  return response.data;
};

export const agregarComentario = async (comentario) => {
  await api.post("/foro", comentario);
};

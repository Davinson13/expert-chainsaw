<script setup>
import { ref, onMounted } from "vue";
import CardCurso from "../components/CardCurso.vue";
import { getCursos } from "../services/cursoService";

const cursos = ref([]);

onMounted(async () => {
  cursos.value = await getCursos();
});
</script>

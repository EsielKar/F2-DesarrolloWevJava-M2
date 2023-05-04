package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReporteCalificacionesTest {

    @Test
    @DisplayName("Genera Lista de estudiantes")
    public void genListaEstudiantes(){

        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();
        Map<Estudiante,Integer> listaCalificaciones = reporteCalificaciones.generaListaCalificaciones(5);
//        System.out.println(listaCalificaciones);
        assertEquals(5, listaCalificaciones.size());
    }

    @Test
    @DisplayName("Ordenar Cursos")
    public void ordenaCursos(){
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();
        Map<Estudiante,Integer> listaCalificaciones = reporteCalificaciones.generaListaCalificaciones(5);
        List<Curso> cursos = List.of(new Curso(5L, "2022", new Materia(1L,"Quimica"),listaCalificaciones)
                ,new Curso(8L, "2028", new Materia(1L,"Quimica"),listaCalificaciones)
                ,new Curso(1L, "2021", new Materia(1L,"Quimica"),listaCalificaciones));
        cursos = reporteCalificaciones.sortCursos(cursos);
        assertThat(cursos.stream().map(Curso::getCiclo)).containsExactly("2021","2022","2028");
    }

}
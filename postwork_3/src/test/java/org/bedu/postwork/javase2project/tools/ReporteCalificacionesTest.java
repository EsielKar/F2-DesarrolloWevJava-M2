package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class ReporteCalificacionesTest {
    private static final Materia MATERIA = new Materia();
    private static final Estudiante ESTUDIANTE_1 = new Estudiante();
    private static final Estudiante ESTUDIANTE_2 = new Estudiante();
    private static final Estudiante ESTUDIANTE_3 = new Estudiante();
    private static final Estudiante ESTUDIANTE_4 = new Estudiante();
    private static final Estudiante ESTUDIANTE_5 = new Estudiante();
    private static final Curso CURSO = new Curso();

    private static ReporteCalificaciones.Reporte reporte1;
    private static ReporteCalificaciones.Reporte reporte2;
    private static ReporteCalificaciones.Reporte reporte3;
    private static ReporteCalificaciones.Reporte reporte4;
    private static ReporteCalificaciones.Reporte reporte5;

    static{
        MATERIA.setNombre("Desarrollo Web Java");

        ESTUDIANTE_1.setNombreCompleto("Maria");
        ESTUDIANTE_2.setNombreCompleto("Benito");
        ESTUDIANTE_3.setNombreCompleto("Arturo");
        ESTUDIANTE_4.setNombreCompleto("Roberto");
        ESTUDIANTE_5.setNombreCompleto("Dolores");

        CURSO.setCiclo("2030");
        CURSO.setMateria(MATERIA);

        Map<Estudiante,Integer> calificaciones = new HashMap<>();
        calificaciones.put(ESTUDIANTE_1, 8);
        calificaciones.put(ESTUDIANTE_2, 5);
        calificaciones.put(ESTUDIANTE_3, 9);
        calificaciones.put(ESTUDIANTE_4, 6);
        calificaciones.put(ESTUDIANTE_5, 7);

        CURSO.setCalificaciones(calificaciones);

        reporte1 = new ReporteCalificaciones.Reporte("Maria", 8);
        reporte2 = new ReporteCalificaciones.Reporte("Benito", 5);
        reporte3 = new ReporteCalificaciones.Reporte("Arturo", 9);
        reporte4 = new ReporteCalificaciones.Reporte("Roberto", 6);
        reporte5 = new ReporteCalificaciones.Reporte("Dolores", 7);


    }

    @Test
    @DisplayName("Ordena alfabéticamente")
    void alfabetico(){
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.alfabetico(CURSO)).containsExactly(reporte3, reporte2, reporte5, reporte1, reporte4);
    }


    @Test
    @DisplayName("Ordena por calificaciones")
    void calificaciones(){
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.calificacion(CURSO)).containsExactly(reporte3, reporte1, reporte5, reporte4, reporte2);
    }

}
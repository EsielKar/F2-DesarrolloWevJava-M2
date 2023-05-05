package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.model.SolicitudEstudiante;
import org.bedu.postwork.javase2project.multithreading.ReceptorSolicitudes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InscripcionAlumnos {
    public static void main(String[] args) {
        Random rnd = new Random();

        ReceptorSolicitudes eventLoop = new ReceptorSolicitudes(event -> {
            if (event.getCurso() == null || event.getEstudiante() == null){
                System.out.println("Inscripcion rechazada por datos invalidos");
            }
            System.out.println(event);
        });

        eventLoop.activar();
        List<SolicitudEstudiante> solicitudes = generaSolicitudes(20);

        for (SolicitudEstudiante s: solicitudes) {
            eventLoop.agregarSolicitud(s);
            detenerSegundos(50);
        }
    }

    public static List<Curso> generaCursos(int numCursos){
        List<Curso> listaCursos = new ArrayList<>(numCursos);
        Long id = 0L;
        String ciclo = "2023-";

        for (int i = 1; i <=numCursos ; i++) {
            id = (long)i;
            Materia materia = new Materia(id,"Materia-" + i);
            listaCursos.add(new Curso(id,(ciclo + i),materia));
        }
        return listaCursos;
    }

    public static List<SolicitudEstudiante> generaSolicitudes(int numSolicitudes){
        Random rnd = new Random();
        List<SolicitudEstudiante> solicitudes = new ArrayList<>();
        List<Estudiante> estudiantes = generaEstudiantes(numSolicitudes);
        List<Curso> cursos = generaCursos(numSolicitudes);
        for (int i = 0; i < numSolicitudes ; i++) {
            solicitudes.add( new SolicitudEstudiante(estudiantes.get(rnd.nextInt(numSolicitudes)),
                    cursos.get(rnd.nextInt(numSolicitudes))));
        }
        return solicitudes;
    }

    public static List<Estudiante> generaEstudiantes(int numEstudiantes){
        List<Estudiante> estudianteList = new ArrayList<>(numEstudiantes);
        for (int i = 1; i <=numEstudiantes; i++) {
            estudianteList.add(new Estudiante((long)i,"Nombre-"+i));
        }
        return estudianteList;
    }

    public static void detenerSegundos(int tiempo){
        try {
            TimeUnit.MILLISECONDS.sleep(tiempo);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

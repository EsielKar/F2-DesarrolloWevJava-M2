package org.bedu.postwork.javase2project;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.multithreading.CalculadorPromedioCurso;
import org.bedu.postwork.javase2project.multithreading.GeneraDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class postwork02 {

    public static void main(String[] args) {

        GeneraDatos generaDatos = new GeneraDatos();
        List<Materia> materias = generaDatos.generaMaterias();
        List<Curso> cursos = new ArrayList<>();
        for (int i = 0; i < materias.size(); i++) {
            cursos.add(new Curso((long) i, "20" + i, materias.get(i), generaDatos.generaCalificaciones()));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Curso curso : cursos) {
            executorService.execute(new CalculadorPromedioCurso(curso));
        }
        executorService.shutdown();

    }

}

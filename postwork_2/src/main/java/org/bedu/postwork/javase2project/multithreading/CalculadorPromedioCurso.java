package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;

public class CalculadorPromedioCurso implements Runnable {

    private Curso curso;
    private double promedio;

    public CalculadorPromedioCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void run() {
        int numAlumnos = 0;
        for (int calificacion : curso.getCalificaciones().values()) {
            promedio += calificacion;
            numAlumnos++;
        }

        promedio /= numAlumnos;

        System.out.println("El promedio del curso " + curso.getId() + " " + curso.getMateria().getNombre() + " es: " + promedio);

    }
}

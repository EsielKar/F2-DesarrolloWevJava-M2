package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;

public class CalculadorPromedioCurso implements Runnable{
    private final Curso curso;

    public CalculadorPromedioCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void run() {
        System.out.println("El promedio del curso : " + curso.getId() +
                " ciclo " + curso.getCiclo() + " es " + curso.getMateria().getNombre() +
                " promedio :" + String.format("%.2f",promedio()));
    }

    private double promedio() {
        return curso.getCalificaciones().values().stream().mapToDouble(n -> n).average().orElse(Double.NaN);
    }
}

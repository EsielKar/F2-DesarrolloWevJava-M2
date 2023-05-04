package org.bedu.postwork.javase2project.reactive;

import org.bedu.postwork.javase2project.model.Curso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public class CalcularPromedioCursoRx {
    private final Curso curso;

    public CalcularPromedioCursoRx(Curso curso) {
        this.curso = curso;
    }

    public Mono<Double> calcularPromedio() {
        return Flux.fromIterable(curso.getCalificaciones().values())
                .collect(Collectors.averagingDouble(n -> n));
    }
}
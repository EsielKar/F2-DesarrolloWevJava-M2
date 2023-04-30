package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Curso;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReporteCalificaciones {

    public Map<Estudiante, Integer> generaListaCalificaciones(int numEstudiantes){
        IntFunction<Estudiante> crea = est -> new Estudiante((long)est,
                "Nombre".concat(String.valueOf(est))
                );

        List<Estudiante> listaEstudinates = IntStream.rangeClosed(1,numEstudiantes)
                .mapToObj(crea)
                .collect(Collectors.toList());

        return listaEstudinates.stream()
                .collect(Collectors.toMap(Function.identity(), est -> ThreadLocalRandom.current().nextInt(100)));

    }

    public List<Curso> sortCursos(List<Curso> listaCursos){
        return listaCursos.stream()
                .sorted(Comparator.comparing(Curso::getCiclo))
                .collect(Collectors.toList());
    }

    public Map<Estudiante,Integer> sortCalificaciones(Map<Estudiante,Integer> mapEstudiantes){
        return mapEstudiantes.entrySet()
                .stream().sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> v1, LinkedHashMap::new
                ));
    }
}

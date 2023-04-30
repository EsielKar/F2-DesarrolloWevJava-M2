package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneraDatos {

    public List<Estudiante> generaEstudiantes(){
        return IntStream.rangeClosed(1, 19)
                .mapToObj(i -> new Estudiante((long)i, "Estudiante_" + i))
                .collect(Collectors.toList());
    }

    public List<Materia> generaMaterias(){
        return IntStream.rangeClosed(1,19)
                .mapToObj(i -> new Materia((long)i, "Materia_" + i))
                .collect(Collectors.toList());
    }

    public Map<Estudiante, Integer> generaCalificaciones(){
        Map<Estudiante,Integer> calificaciones = new HashMap<>();
        for (Estudiante e: generaEstudiantes()) {
            calificaciones.put(e,generaNumeroAleatorio());
        }
        return calificaciones;
    }

    public static int generaNumeroAleatorio(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }


}

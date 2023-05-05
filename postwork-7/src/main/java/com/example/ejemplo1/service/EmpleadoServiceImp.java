package com.example.ejemplo1.service;

import com.example.ejemplo1.entity.Empleado;
import com.example.ejemplo1.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmpleadoServiceImp implements EmpleadoService {
    private final EmpleadoRepository repository;

    @Autowired
    public EmpleadoServiceImp(EmpleadoRepository repository) {
        this.repository = repository;
    }

    static Map<String, Empleado> empleadoData; //String es la llava que va a buscar

    static {
        empleadoData = new HashMap<>();
        empleadoData.put("1", new Empleado("1", "Empleado 1"));
        empleadoData.put("2", new Empleado("2", "Empleado 2"));
        empleadoData.put("3", new Empleado("3", "Empleado 3"));
        empleadoData.put("4", new Empleado("4", "Empleado 4"));
        empleadoData.put("5", new Empleado("5", "Empleado 5"));
        empleadoData.put("6", new Empleado("6", "Empleado 6"));
        empleadoData.put("7", new Empleado("7", "Empleado 7"));
        empleadoData.put("8", new Empleado("8", "Empleado 8"));
        empleadoData.put("9", new Empleado("9", "Empleado 9"));
        empleadoData.put("10", new Empleado("10", "Empleado 10"));

    }

    //de que forma se va a manejar esta informacion, con que metodos
    //programacion reactiva
    @Override
    public Mono<Empleado> findEmpleadoById(String id) { //un solo empleado
        return Mono.just(empleadoData.get(id));
    }
    @Override
    public Flux<Empleado> findAllEmpleados() {
        return Flux.fromIterable(empleadoData.values());
    }

    @Override
    public Mono<Empleado> updateEmpleado(Empleado employee){
        Empleado existeEmpleado = empleadoData.get(employee.getId());
        if(existeEmpleado != null){
            existeEmpleado.setNombre(employee.getNombre());
        }
        return Mono.just(existeEmpleado);
    }
    @Override
    public Mono<Empleado> updateEmpleadoWithId(String Id, Empleado employee) {
        Empleado existeEmpleado = empleadoData.get(Id);
        if (existeEmpleado != null) {
            existeEmpleado.setNombre(employee.getNombre());
        }
        return Mono.just(existeEmpleado);
    }


}

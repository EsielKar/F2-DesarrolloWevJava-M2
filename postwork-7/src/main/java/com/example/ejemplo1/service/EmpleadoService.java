package com.example.ejemplo1.service;

import com.example.ejemplo1.entity.Empleado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmpleadoService {

    Mono<Empleado> findEmpleadoById(String id);
    Flux<Empleado> findAllEmpleados();
    Mono<Empleado> updateEmpleado(Empleado employee);
    Mono<Empleado> updateEmpleadoWithId(String Id, Empleado employee);


}

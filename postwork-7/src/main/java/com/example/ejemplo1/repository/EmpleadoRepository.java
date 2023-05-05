package com.example.ejemplo1.repository;

import com.example.ejemplo1.entity.Empleado;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository //reconoce la clase como un repositorio
public interface EmpleadoRepository extends ReactiveMongoRepository<Empleado, String> {




}

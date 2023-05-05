package com.example.ejemplo1.controller;

import com.example.ejemplo1.entity.Empleado;
import com.example.ejemplo1.service.EmpleadoService;
import com.example.ejemplo1.service.EmpleadoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    //como es programacion reactiva vamos a manejar flujos de datos

    private final EmpleadoService service;

   @Autowired
    public EmpleadoController(EmpleadoServiceImp service) {
        this.service = service;
    }


    @GetMapping
        private Flux<Empleado> getAllEmpleados(){
       return service.findAllEmpleados();
        }

    @GetMapping("/{id}")
    private Mono<Empleado> getEmpleadoById(@PathVariable String id) {
        return service.findEmpleadoById(id);
    }


    @PostMapping("/update")
    private Mono<Empleado> updateEmpleado(@RequestBody Empleado empleado){
        return service.updateEmpleado(empleado);
    }

    @PutMapping("/{id}")
    private Mono<Empleado> updateEmpleadoWithId(@PathVariable String id, @RequestBody Empleado empleado) {
        return service.updateEmpleadoWithId(id, empleado);
    }




}

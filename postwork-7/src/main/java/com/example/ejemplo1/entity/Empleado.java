package com.example.ejemplo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//constructor con dos argumentos id y nombre
@NoArgsConstructor//constructor sin valores
public class Empleado {
    private String id;
    private String nombre;
}

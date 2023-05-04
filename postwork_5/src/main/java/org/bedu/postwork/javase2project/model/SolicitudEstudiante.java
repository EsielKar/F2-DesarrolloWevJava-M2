package org.bedu.postwork.javase2project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolicitudEstudiante {
    private Estudiante estudiante;
    private Curso curso;
}

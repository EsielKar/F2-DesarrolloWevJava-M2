package org.bedu.postwork.javase2project.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@AllArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {

    public static final Integer NO_CALIFICADO = -100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ciclo")

    private String ciclo;

    @ManyToOne
    @JoinColumn(name = "materias_fk", referencedColumnName = "id")
    private Materia materia;

    @ElementCollection
    @CollectionTable(name = "cursos_has_estudiantes", joinColumns = {@JoinColumn(name = "cursos_fk", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "estudiantes_fk", referencedColumnName = "id")
    @Column(name = "calificacion")
    private Map<Estudiante, Integer> calificaciones;

    public Curso(Long id, String ciclo, Materia materia) {
        this.id = id;
        this.ciclo = ciclo;
        this.materia = materia;
    }
}

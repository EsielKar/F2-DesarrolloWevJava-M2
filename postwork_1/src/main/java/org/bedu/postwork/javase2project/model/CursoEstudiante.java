package org.bedu.postwork.javase2project.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cursos_has_estudiantes")
public class CursoEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cursos_fk", referencedColumnName = "id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "estudiantes_fk", referencedColumnName = "id")
    private Estudiante estudiante;

    @Column(name = "calificacion")
    private int calificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursoEstudiante that)) return false;
        return getCalificacion() == that.getCalificacion() && getId().equals(that.getId()) && getCurso().equals(that.getCurso()) && getEstudiante().equals(that.getEstudiante());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCurso(), getEstudiante(), getCalificacion());
    }
}
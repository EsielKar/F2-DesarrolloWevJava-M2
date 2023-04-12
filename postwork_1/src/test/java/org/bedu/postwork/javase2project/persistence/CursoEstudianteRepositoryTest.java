package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.CursoEstudiante;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CursoEstudianteRepositoryTest {

    @Autowired
    private CursoEstudianteRepository cursoEstudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private MateriaRepository materiaRepository;

    Curso cursoCal;
    Estudiante estudianteCal;

    Materia materiaCal;

    @BeforeAll


        // Limpia las tablas y luego Crea un estudiante, una materia y un curso
    void creaCursoEstudiante() {

        cursoEstudianteRepository.deleteAll();
        cursoRepository.deleteAll();
        materiaRepository.deleteAll();
        estudianteRepository.deleteAll();

        estudianteCal = new Estudiante();
        estudianteCal.setNombre("Hector Bravo");
        estudianteRepository.save(estudianteCal);

        materiaCal = new Materia();
        materiaCal.setNombre("Biologia");
        materiaRepository.save(materiaCal);

        cursoCal = new Curso();
        cursoCal.setCiclo("2023");
        cursoCal.setMateriaId(materiaCal);
        cursoRepository.save(cursoCal);

    }

    @Test
    @DisplayName("Agrega calificacion")
    public void testAgregarCalificacion() {

        // Crear un registro en la tabla cursos_has_estudiantes
        CursoEstudiante cursoEstudiante = new CursoEstudiante();
        cursoEstudiante.setCurso(cursoCal);
        cursoEstudiante.setEstudiante(estudianteCal);
        cursoEstudiante.setCalificacion(9);

        cursoEstudianteRepository.save(cursoEstudiante);

        // Verificar que el registro se haya agregado correctamente
        assertNotNull(cursoEstudiante.getCurso());
        assertNotNull(cursoEstudiante.getEstudiante());
        assertEquals(9, cursoEstudiante.getCalificacion());
    }
}
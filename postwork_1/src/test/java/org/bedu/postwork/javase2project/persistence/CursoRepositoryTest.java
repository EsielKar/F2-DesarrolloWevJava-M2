package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Curso;
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
class CursoRepositoryTest {
    @Autowired
    private CursoRepository repository;
    @Autowired
    private MateriaRepository materiaRepository;

    @BeforeAll
    void cleanDatabase() {
        repository.deleteAll();
        materiaRepository.deleteAll();
    }

    @Test
    @DisplayName("Guardado")
    void canSave() {
        Materia materiaTest = new Materia();
        materiaTest.setNombre("Matematicas");
        materiaTest = materiaRepository.save(materiaTest);

        Curso cursoTest = new Curso();
        cursoTest.setCiclo("2023");
        cursoTest.setMateriaId(materiaTest);
        cursoTest = repository.save(cursoTest);

        assertNotNull(cursoTest.getId());
        assertEquals("2023", cursoTest.getCiclo());
        assertEquals("Matematicas", cursoTest.getMateriaId().getNombre());

    }

}
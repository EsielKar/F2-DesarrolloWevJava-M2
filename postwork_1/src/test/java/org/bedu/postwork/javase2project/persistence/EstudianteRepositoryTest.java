package org.bedu.postwork.javase2project.persistence;


import org.bedu.postwork.javase2project.model.Estudiante;
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
class EstudianteRepositoryTest {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @BeforeAll
    void cleanDatabase() {
        estudianteRepository.deleteAll();
    }

    @Test
    @DisplayName("Guardado")
    void canSave() {
        Estudiante estudianteTest = new Estudiante();
        estudianteTest.setNombre("Hector Bravo");

        estudianteTest = estudianteRepository.save(estudianteTest);

        assertNotNull(estudianteTest.getId());
    }


}
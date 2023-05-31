package tv.codely.mooc.courses.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.*;
import tv.codely.mooc.courses.infrastructure.persistence.course.module.integration.test.CoursesModuleInfrastuctureTestCase;

import java.util.Optional;

public class InMemoryCourseRepositoryShould extends CoursesModuleInfrastuctureTestCase {
    //Test de Integración, se prueba la implementación real
    @Test
    void saveAValidCourse() {
        Course course = CourseMother.random();
        repository.save(course);
        //no hubo falta respuesta con assert, debido a que si lanza excepción quiere decir que hubo entonces error, sino, está everything correcto
    }

    //para probar la funcionalidad de que la infraestructura está funcionando correctamente
    @Test
    void searchAnExistingCourse() {
        Course courseExpected = CourseMother.random();
        repository.save( courseExpected );

        System.out.println("from test: " + courseExpected.getId().value() + ", " + courseExpected.getName().getValue() + ", " + courseExpected.getDuration().getValue());
        Optional<Course> opActualCourse = repository.search( courseExpected.getId() );

        Course courseActual = opActualCourse.orElse(new Course());
        assertEquals(courseExpected, courseActual);
    }

    @Test
    void searchNotExistingCourse() {
        Optional<Course> opActualCourse = repository.search( CourseIdMother.random() );

        assertFalse(opActualCourse.isPresent());
    }
}

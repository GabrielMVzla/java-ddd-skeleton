package tv.codely.mooc.courses.infrastructure.persistence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.*;
import tv.codely.mooc.courses.CoursesModuleInfrastuctureTestCase;

import java.util.Optional;

public class InMemoryCourseRepositoryShould extends CoursesModuleInfrastuctureTestCase {
    //Test de Integración, se prueba la implementación real
    @Test
    void saveAValidCourse() {
        Course course = CourseMother.random();
        inMemoryCourseRepository.save(course);
        //no hubo falta respuesta con assert, debido a que si lanza excepción quiere decir que hubo entonces error, sino, está everything correcto
    }

    //para probar la funcionalidad de que la infraestructura está funcionando correctamente
    @Test
    void searchAnExistingCourse() {
        Course courseExpected = CourseMother.random();
        inMemoryCourseRepository.save( courseExpected );

        System.out.println("from test: " + courseExpected.getId() + ", " + courseExpected.getName().getValue() + ", " + courseExpected.getDuration().getValue());
        Optional<Course> opActualCourse = inMemoryCourseRepository.search( courseExpected.getId() );

        Course courseActual = opActualCourse.orElse(new Course());
        assertEquals(courseExpected, courseActual);
    }

    @Test
    void searchNotExistingCourse() {
        Optional<Course> opActualCourse = inMemoryCourseRepository.search( CourseIdMother.random() );

        assertFalse(opActualCourse.isPresent());
    }
}

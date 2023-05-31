package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.*;

import java.util.Optional;

public class InMemoryCourseRepositoryShould {
    //Test de Integración, se prueba la implementación real
    @Test
    void saveAValidCourse() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
//        Course course = CourseMother.random(); //contra menos sepamos mejor, solo conocemos al vecino
        Course course = new Course(
            new CourseId( "550e8400-e29b-41d4-a716-44665440000" ),
            CourseNameMother.random(),
            new CourseDuration( "duration" )
        );
        repository.save(course);
        //no hubo falta respuesta con assert, debido a que si lanza excepción quiere decir que hubo entonces error, sino, está everything correcto
    }

    //para probar la funcionalidad de que la infraestructura está funcionando correctamente
    @Test
    void searchAnExistingCourse() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Course courseExpected = new Course(
            new CourseId( "550e8400-e29b-41d4-a716-44665440000" ),
            new CourseName( "name"),
            new CourseDuration( "duration" )
        );
        repository.save( courseExpected );

        Optional<Course> opActualCourse = repository.search("some-id");

        Course courseActual = opActualCourse.orElse(new Course());
        assertEquals(courseExpected, courseActual);
    }

    @Test
    void searchNotExistingCourse() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Optional<Course> opActualCourse = repository.search("550e8400-e29b-41d4-a716-44665440000");

        assertFalse(opActualCourse.isPresent());
    }
}

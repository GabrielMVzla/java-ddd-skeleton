package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;

import java.util.Optional;

public class InMemoryCourseRepositoryShould {
    //Test de Integración, se prueba la implementación real

    @Test
    void saveAValidCourse() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        repository.save(new Course("some-id", "some-name", "some-duration"));
        //no hubo falta respuesta con assert, debido a que si lanza excepción quiere decir que hubo entonces error, sino, está everything correcto
    }

    //para probar la funcionalidad de que la infraestructura está funcionando correctamente
    @Test
    void searchAnExistingCourse() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Course courseExpected = new Course("some-id", "some-name", "some-duration");
        repository.save( courseExpected );

        Optional<Course> opActualCourse = repository.search("some-id");

        Course courseActual = opActualCourse.orElse(new Course());
        assertEquals(courseExpected, courseActual);
    }

    @Test
    void searchNotExistingCourse() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Optional<Course> opActualCourse = repository.search("id-no-existente");

        assertFalse(opActualCourse.isPresent());
    }
}

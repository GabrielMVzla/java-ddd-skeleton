package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;

import static org.mockito.Mockito.*;

final class CourseCreatorShould {
    @Test //prueba unitaria,
    void createAValidCourse() {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator    creator    = new CourseCreator(repository);

        String id       = "some-id";
        String name     = "name";
        String duration = "duration";

        Course course = new Course(id, name, duration);

        //llamar caso de uso
        creator.create(course.id(), course.name(), course.duration());

        //verifica que se llama "save", eso es lo que estamos verificando, por otro lado se valida que sí se guarda pero ya es en test de integración
        verify(repository, atLeastOnce()).save(course);
        //importante overridear el equals porque sino, entonces este curso es diferente al que se crea dentro del servicio de dominio
    }
}

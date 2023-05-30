package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.*;

import static org.mockito.Mockito.*;

final class CourseCreatorShould {
    @Test //prueba unitaria,
    void createAValidCourse() {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator    creator    = new CourseCreator(repository);

        CreateCourseRequest request = new CreateCourseRequest("some-id", "name", "duration");

        Course course = new Course(
            new CourseId( request.getId() ),
            new CourseName( request.getName() ),
            new CourseDuration( request.getDuration() )
        );

        //llamar caso de uso
        creator.create( request );

        //verifica que se llama "save", eso es lo que estamos verificando, por otro lado se valida que sí se guarda pero ya es en test de integración
        verify(repository, atLeastOnce()).save(course);
        //importante overridear el equals porque sino, entonces este curso es diferente al que se crea dentro del servicio de dominio
    }
}

package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.*;
import tv.codely.mooc.courses.infrastructure.persistence.InMemoryCourseRepository;

import static org.mockito.Mockito.*;

final class CourseCreatorShould {
    @Test //prueba unitaria,
    void createAValidCourse() {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator    creator    = new CourseCreator(repository);
//        Course course = CourseMother.random(); //contra menos sepamos mejor, solo conocemos al vecino
        CreateCourseRequest courseRequest = CourseCreatorMother.random();

        Course course = CourseMother.fromRequest(courseRequest);
        System.out.println("from test: " + course.getId().value() + ", " + course.getName().getValue() + ", " + course.getDuration().getValue());

        //llamar caso de uso
        creator.create( courseRequest );

        //verifica que se llama "save", eso es lo que estamos verificando, por otro lado se valida que sí se guarda pero ya es en test de integración
        verify(repository, atLeastOnce()).save(course);
        //importante overridear el equals porque sino, entonces este curso es diferente al que se crea dentro del servicio de dominio
    }
}

package tv.codely.mooc.courses;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.shared.infrastructure.UnitTestCase;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import static org.mockito.Mockito.*;

public abstract class CoursesModuleUnitTestCase extends UnitTestCase {
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp(){
        repository = mock(CourseRepository.class);
    }

    protected void shoulHaveSaved(Course course){
        //verifica que se llama "save", eso es lo que estamos verificando, por otro lado se valida que sí se guarda pero ya es en test de integración
        verify(repository, atLeastOnce()).save(course);
        //importante overridear el equals porque sino, entonces este curso es diferente al que se crea dentro del servicio de dominio
    }
}

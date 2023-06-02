package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.courses.domain.CourseMother;
import tv.codely.mooc.courses.CoursesModuleInfrastuctureTestCase;
import tv.codely.mooc.courses.domain.CourseRepository;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
public class H2CourseRepositoryShould extends CoursesModuleInfrastuctureTestCase {

    @Test
    void saveAValidCourse() {
        Course course = CourseMother.random();
        h2CourseRepository.save(course);
        //no hubo falta respuesta con assert, debido a que si lanza excepción quiere decir que hubo entonces error, sino, está everything correcto
    }

    //para probar la funcionalidad de que la infraestructura está funcionando correctamente
    @Test
    void searchAnExistingCourse() {
        Course courseExpected = CourseMother.random();
        h2CourseRepository.save( courseExpected );

        System.out.println("from test: " + courseExpected.getId() + ", " + courseExpected.getName().getValue() + ", " + courseExpected.getDuration().getValue());
        Optional<Course> opActualCourse = h2CourseRepository.search( courseExpected.getId() );

        Course courseActual = opActualCourse.orElse(new Course());
        assertEquals(courseExpected, courseActual);
    }

    @Test
    void searchNotExistingCourse() {
        Optional<Course> opActualCourse = h2CourseRepository.search( CourseIdMother.random() );

        assertFalse(opActualCourse.isPresent());
    }

}

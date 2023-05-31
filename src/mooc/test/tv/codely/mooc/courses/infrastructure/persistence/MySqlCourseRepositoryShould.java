package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.courses.domain.CourseMother;
import tv.codely.mooc.courses.infrastructure.persistence.course.module.integration.test.CoursesModuleInfrastuctureTestCase;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MySqlCourseRepositoryShould extends CoursesModuleInfrastuctureTestCase {

    @Test
    void saveAValidCourse() {
        Course course = CourseMother.random();
        mySqlCourseRepository.save(course);
        //no hubo falta respuesta con assert, debido a que si lanza excepción quiere decir que hubo entonces error, sino, está everything correcto
    }

    //para probar la funcionalidad de que la infraestructura está funcionando correctamente
    @Test
    void searchAnExistingCourse() {
        Course courseExpected = CourseMother.random();
        mySqlCourseRepository.save( courseExpected );

        System.out.println("from test: " + courseExpected.getId() + ", " + courseExpected.getName().getValue() + ", " + courseExpected.getDuration().getValue());
        Optional<Course> opActualCourse = mySqlCourseRepository.search( courseExpected.getId() );

        Course courseActual = opActualCourse.orElse(new Course());
        assertEquals(courseExpected, courseActual);
    }

    @Test
    void searchNotExistingCourse() {
        Optional<Course> opActualCourse = mySqlCourseRepository.search( CourseIdMother.random() );

        assertFalse(opActualCourse.isPresent());
    }

}

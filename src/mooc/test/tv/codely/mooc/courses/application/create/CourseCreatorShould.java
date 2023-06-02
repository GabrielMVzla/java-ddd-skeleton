package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CoursesModuleUnitTestCase;
import tv.codely.mooc.courses.domain.*;

final class CourseCreatorShould extends CoursesModuleUnitTestCase {

    private CourseCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        creator = new CourseCreator(repository);
    }

    @Test //prueba unitaria, tiene sus pros y sus contras ya que metemos más clases y demás
    void createAValidCourse() {
        CreateCourseRequest courseRequest = CourseCreatorMother.random();

        Course course = CourseMother.fromRequest(courseRequest);

        //llamar caso de uso
        creator.create( courseRequest );

        shoulHaveSaved(course);
    }
}

package tv.codely.mooc.courses;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.shared.infrastructure.InfrastuctureTestCase;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.infrastructure.persistence.InMemoryCourseRepository;

//clase base para todos los testing de cursos
public class CoursesModuleInfrastuctureTestCase extends InfrastuctureTestCase {

    protected InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();
    @Autowired
    protected CourseRepository         mySqlCourseRepository;}

package tv.codely.mooc.courses.infrastructure.persistence.course.module.integration.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import tv.codely.mooc.courses.InfrastuctureTestCase;
import tv.codely.mooc.courses.infrastructure.persistence.InMemoryCourseRepository;

//clase base para todos los testing de cursos
public class CoursesModuleInfrastuctureTestCase extends InfrastuctureTestCase {

    @Autowired
    protected InMemoryCourseRepository repository;
}

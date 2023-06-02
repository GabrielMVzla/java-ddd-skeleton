package tv.codely.mooc.courses.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

import java.util.HashMap;
import java.util.Optional;

@Repository("inmemory")
//@Service
public  class InMemoryCourseRepository implements CourseRepository {
    private HashMap<CourseId, Course> courses = new HashMap<>();

    public void save(Course course) {
        System.out.println("entró al inmemory");
        courses.put(course.getId(), course);
    }

    public Optional<Course> search(CourseId id) {
        courses.forEach((k, v) -> System.out.println(k + ": " + v));
        return Optional.ofNullable(courses.get(id));
    }
}

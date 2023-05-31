package tv.codely.mooc.courses.infrastructure.persistence;

import org.springframework.stereotype.Repository;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public  class InMemoryCourseRepository implements CourseRepository {
    private HashMap<String, Course> courses = new HashMap<>();

    public void save(Course course) {
        courses.put(course.getId().value(), course);
    }

    public Optional<Course> search(String id) {
        courses.forEach((k, v) -> System.out.println(k + ": " + v));
        return Optional.ofNullable(courses.get(id));
    }
}

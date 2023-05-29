package tv.codely.mooc.courses.application.create;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

//Se crea en esta carpeta para poder reutilizar desde donde sea este servicio de aplicación, en cualquiera de nuestras aplicaciones, se crea en este bounded context pq tiene que ver con este tema
@Service
public final class CourseCreator {
    private CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCourseRequest request) {
        Course course = new Course(request.getId(), request.getName(), request.getDuration());

        this.repository.save(course);
    }
}

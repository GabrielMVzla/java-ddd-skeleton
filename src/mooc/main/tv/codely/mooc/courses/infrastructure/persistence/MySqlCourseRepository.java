package tv.codely.mooc.courses.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

import javax.transaction.Transactional;
import java.util.Optional;

//se agregó hibernate dentro de la infrastucture de cada modulo para tenerlo más cerca
@Repository("mysql")
//@Primary
//@Service
@Primary
public class MySqlCourseRepository implements CourseRepository {
    private SessionFactory sessionFactory;

    public MySqlCourseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void save(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Course.class, id));
    }
}

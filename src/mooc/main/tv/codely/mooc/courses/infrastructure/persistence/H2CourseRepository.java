package tv.codely.mooc.courses.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.infrastructure.persistence.hibernate.HibernateRepository;
import tv.codely.shared.domain.Service;

import javax.transaction.Transactional;
import java.util.Optional;

//se agregó hibernate dentro de la infrastucture de cada modulo para tenerlo más cerca
@Repository("h2")
@Primary
//@Service
public class H2CourseRepository extends HibernateRepository<Course> implements CourseRepository {

    public H2CourseRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Course.class);
    }

    @Transactional
    public void save(Course course) {
        System.out.println("h2 mensaje de entrada log");
        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Course.class, id.getValue()));
    }
}

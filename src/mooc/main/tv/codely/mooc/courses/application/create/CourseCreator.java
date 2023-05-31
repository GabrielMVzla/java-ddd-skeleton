package tv.codely.mooc.courses.application.create;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.courses.domain.*;
import tv.codely.shared.domain.Service;

//Se crea en esta carpeta para poder reutilizar desde donde sea este servicio de aplicación, en cualquiera de nuestras aplicaciones, se crea en este bounded context pq tiene que ver con este tema
@Service
public final class CourseCreator {
    private CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    //toda query dentro de hibernate ha de ser transactional, quien se debe encargar de la transacción es el service o más bien el command bus pero más adelante,
    // ya que el caso de uso es el orquestador de servicios de dominio, y cada servicio de dominio puede cambiar diferente estado de diferente tabla en neustra bdd
    public void create(CreateCourseRequest request) {
        Course course = new Course(
            new CourseId( request.getId() ),
            new CourseName( request.getName() ),
            new CourseDuration( request.getDuration() )
        );

        this.repository.save(course);
    }
}

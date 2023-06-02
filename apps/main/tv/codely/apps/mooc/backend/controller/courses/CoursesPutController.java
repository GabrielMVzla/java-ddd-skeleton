package tv.codely.apps.mooc.backend.controller.courses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.courses.application.create.CourseCreator;
import tv.codely.mooc.courses.application.create.CreateCourseRequest;

@RestController
public final class CoursesPutController {
    private final CourseCreator creator;

    public CoursesPutController(CourseCreator creator) {
        this.creator = creator;
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity create(@PathVariable String id, @RequestBody Request request) {
        //con DTO desacoplamos nuestro controlador de servicios de aplicación, usar neustros DTO es beneficioso debido a que hay casos donde se duplica la lógica de comunicación, entonces al utilizar DTOs
        //podemos reutilizarlo, al utilizarlo en diferentes casos de uso que sea requerido, a diferencia de usar un simple Request, transición hacia CQRS poco a poco
        creator.create(new CreateCourseRequest(id, request.name(), request.duration()));

        return new ResponseEntity(HttpStatus.CREATED);
    }
}

//este request es un protocolo de comunicación que usa spring, y el responseEntity basico
final class Request {
    private String name;
    private String duration;

    String name() {
        return name;
    }

    String duration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }
}

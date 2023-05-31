package tv.codely.mooc.courses.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

//Curso compuesto por valueObjects, pero CourseId es un identificador
@Entity
@Table(name = "courses")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public final class Course  {

    @Id
    private CourseId id;
    private CourseName name;
    private CourseDuration duration;

}

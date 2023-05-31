package tv.codely.mooc.courses.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//Curso compuesto por valueObjects, pero CourseId es un identificador
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Course  {

    private CourseId id;
    private CourseName name;
    private CourseDuration duration;
}

package tv.codely.mooc.courses.application.create;

import lombok.*;
import tv.codely.mooc.courses.domain.CourseDuration;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseName;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequest {

    private String id;
    private String name;
    private String duration;

}

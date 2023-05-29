package tv.codely.mooc.courses.application.create;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequest {

    private String id;
    private String name;
    private String duration;

}

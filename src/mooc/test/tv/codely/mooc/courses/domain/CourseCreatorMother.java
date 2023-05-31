package tv.codely.mooc.courses.domain;

import tv.codely.mooc.courses.application.create.CreateCourseRequest;

public class CourseCreatorMother { //request

    public static CreateCourseRequest create(CourseId id, CourseName name, CourseDuration duration){
        return new CreateCourseRequest(id.value(), name.getValue(), duration.getValue());
    }

    public static CreateCourseRequest random(){
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }

}

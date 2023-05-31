package tv.codely.mooc.courses.domain;

public class CourseIdMother {
    public static CourseId create(String value){
        return new CourseId(value);
    }

    //Objeto aleatorio
    public static CourseId random(){
        return create(UuidMother.random());
    }
}

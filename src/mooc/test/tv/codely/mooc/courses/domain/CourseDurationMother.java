package tv.codely.mooc.courses.domain;

public class CourseDurationMother {
    public static CourseDuration create(String value){
        return new CourseDuration(value);
    }

    //Objeto aleatorio
    public static CourseDuration random(){
        return new create(
            String.format(
                "%s %s",
                IntegerMother.random(),
                RandomElementPicker.from("months", "years", "days", "hours", "minutes", "seconds")
            )
        );
    }
}

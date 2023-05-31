package tv.codely.mooc.courses.domain;

import tv.codely.shared.domain.IntegerMother;
import tv.codely.shared.domain.RandomElementPicker;

public class CourseDurationMother {
    public static CourseDuration create(String value){
        return new CourseDuration(value);
    }

    //Objeto aleatorio
    public static CourseDuration random(){
        return create(
            String.format(
                "%s %s",
                IntegerMother.random(),
                RandomElementPicker.from("months", "years", "days", "hours", "minutes", "seconds")
            )
        );
    }
}

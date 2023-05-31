package tv.codely.mooc.courses.domain;

import tv.codely.shared.domain.Identifier;

import java.io.Serializable;

public class CourseId extends Identifier implements Serializable {

    public CourseId(String value){
        super(value);
    }

    private CourseId() { // esto hace ruido pq instanciaríamos esta clase como invalida, para corregirlo, volvemos private el constructor este y se tiene que hacer por hibernate por temas de reflexion
        super(null);
    }
}

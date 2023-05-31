package tv.codely.mooc.courses.domain;

import tv.codely.shared.domain.Stringable;

public class CourseDuration extends Stringable {

    public CourseDuration(String value) {
        super(value);
    }

    private CourseDuration() { // esto hace ruido pq instanciaríamos esta clase como invalida, para corregirlo, volvemos private el constructor este y se tiene que hacer por hibernate por temas de reflexion
        super(null);
    }
}

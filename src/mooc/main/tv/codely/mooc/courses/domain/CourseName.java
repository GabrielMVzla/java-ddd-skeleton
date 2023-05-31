package tv.codely.mooc.courses.domain;

import tv.codely.shared.domain.Stringable;

public class CourseName extends Stringable {

    public CourseName(String value) {
        super(value);
    }

    private CourseName() { // esto hace ruido pq instanciaríamos esta clase como invalida, para corregirlo, volvemos private el constructor este y se tiene que hacer por hibernate por temas de reflexion
        super(null);
    }
}

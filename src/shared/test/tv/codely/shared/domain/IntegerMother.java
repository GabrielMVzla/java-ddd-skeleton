package tv.codely.shared.domain;

import java.util.Random;

public class IntegerMother {

    //definimos el rango que queremos, de acuerdo a lo que buscamos o necesitamos
    public static Integer random() {
        return new Random().nextInt(5000) + 1;
    }
}

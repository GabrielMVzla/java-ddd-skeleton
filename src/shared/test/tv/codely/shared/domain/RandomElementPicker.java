package tv.codely.shared.domain;

import java.util.Random;

public class RandomElementPicker {

    public static String from(String months, String years, String days, String hours, String minutes, String seconds) {
        String tipoDuracion[] = {months, years, days, hours, minutes, seconds};

        return tipoDuracion[new Random().nextInt(tipoDuracion.length - 1)];
    }
}

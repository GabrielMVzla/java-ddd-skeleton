package tv.codely.shared.domain;

import com.github.javafaker.Faker;

public class WordMother {

    public static String random(){
        return Faker.instance().lorem().word().toString();
    }
}

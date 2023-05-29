package tv.codely.mooc.courses.domain;

import lombok.EqualsAndHashCode;

import java.util.UUID;

//Lo agregamos en shared debido a que vamos a estarlo utilizando para nuestros ids en nuestro aplicativo
@EqualsAndHashCode
public abstract class Identifier {

    private String value;
//    private UUID value;

    public Identifier(String value){
        ensureValidUUid(value);
        this.value = value;
    }

    private void ensureValidUUid(String value) {
        UUID.fromString(value); //si no cumple lanza excepción, eso nos interesa
    }

    public String value(){
        return value;
//        return value.toString();
    } //estamos devolviendo el String, no exponemos UUID como de la manera comentada
}

package tv.codely.mooc.courses.domain;
import tv.codely.shared.domain.*;
import static org.junit.jupiter.api.Assertions.*;

//No es un Test en sí, si no una Factoria que me ayudará a crear una instancia de este objeto, y si cambia su estructura, no cambia cada uno de los testcase
public class CourseNameMother {

    //Suelen tener 2 métodos, uno de creación, mismos argumentos de la clase
    public static CourseName create(String value){
        return new CourseName(value);
    }

    //Objeto aleatorio
    public static CourseName random(){
        return create(tv.codely.shared.domain.WordMother.random());
    }
}

package tv.codely.mooc.courses.application.create;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PruebaTest {

    @Test
    public void miTest() {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("C:\\Aplicaciones\\SALE VALE\\estudios\\java-ddd-skeleton\\src\\mooc\\main\\tv\\codely\\mooc\\courses\\infrastructure\\persistence\\hibernate\\Course.hbm.xml");
        if (resource == null) {
            throw new IllegalArgumentException("Archivo no encontrado!");
        } else {
            File file = new File(resource.getFile());
            System.out.println(file.exists());
            // ...
        }

        // Hacer algo con el recurso...FileSystemResource

//        assertTrue(fileSystemResource.exists());
    }
}

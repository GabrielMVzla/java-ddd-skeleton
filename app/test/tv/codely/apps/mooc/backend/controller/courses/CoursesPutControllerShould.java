package tv.codely.apps.mooc.backend.controller.courses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.app.mooc.backend.MoocBackendApplication;
import tv.codely.apps.mooc.backend.controller.RequestTestCase;

@ContextConfiguration(classes = MoocBackendApplication.class) //vamos a utilizar el mismo contexto de nuestro aplicativo al menos para los tests de integración, pq inicia nuestra aplicación de Springboot
@SpringBootTest //Es la base de un test de Spring boot
public final class CoursesPutControllerShould extends RequestTestCase {
    @DisplayName("Valida que no existe dicho curso")
    @Test
    void createAValidNonExistingCourse() throws Exception {
        this.assertRequestWithBody(
            "PUT",
            "/courses/1aab45ba-3c7a-4344-8936-78466eca77fa",
            "{\"name\": \"The best course\", \"duration\": \"5 hours\"}",
            201
        );
    }
}

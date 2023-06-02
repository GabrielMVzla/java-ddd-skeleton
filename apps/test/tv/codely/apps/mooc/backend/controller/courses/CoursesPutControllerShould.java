package tv.codely.apps.mooc.backend.controller.courses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.backend.controller.RequestTestCase;

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

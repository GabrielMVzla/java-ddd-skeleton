package tv.codely.app.mooc.controller.health_check;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tv.codely.app.mooc.controller.RequestTestCase;

//Test de Aceptación
final class HealthCheckGetControllerShould extends RequestTestCase {
    @Test
    @DisplayName("Comprobar si la aplicación funciona correctamente")
    public void checkAppWorkingOk() throws Exception {
        this.assertResponse("/health-check", 200, "{'status': 'ok'}");
    }
}

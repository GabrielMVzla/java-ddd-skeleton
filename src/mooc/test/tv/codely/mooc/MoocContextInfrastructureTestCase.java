package tv.codely.mooc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.app.mooc.backend.MoocBackendApplication;
import tv.codely.shared.infrastructure.InfrastuctureTestCase;

@ContextConfiguration(classes = MoocBackendApplication.class) //vamos a utilizar el mismo contexto de nuestro aplicativo al menos para los tests de integración, pq inicia nuestra aplicación de Springboot
@SpringBootTest //Es la base de un test de Spring boot
public class MoocContextInfrastructureTestCase extends InfrastuctureTestCase {
}

package tv.codely.shared.infrastructure;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.Starter;

@ContextConfiguration(classes = Starter.class) //vamos a utilizar el mismo contexto de nuestro aplicativo al menos para los tests de integración, pq inicia nuestra aplicación de Springboot
@SpringBootTest //Es la base de un test de Spring boot
public abstract class InfrastuctureTestCase { //De esta clse van a heredar todos los tests de infraestructura al menos para cursos en este caso

}

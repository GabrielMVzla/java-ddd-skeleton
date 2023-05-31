package tv.codely.mooc.shared.infrastructure.persistence;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

//cada bounded context tiene su propia infrastucture, por lo cual tiene sentido que cada 1 tenga la conf de base de datos que le compete
@Configuration //clase de configuración
@EnableTransactionManagement //habilita transaccional para que hibernate sepa
public class MoocHibernateConfiguration {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        List<Resource> mappingFiles = searchMappingFiles();

        sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()])); //cuando te doy a guardar, has de buscar dentro del fichero existente, para decirle nuestros mapping

        return sessionFactory;
    }

    private List<Resource> searchMappingFiles() {
        String path = "./src/mooc/main/tv/codely/mooc/";

        String[]     modules   = subdirectoriesFor(path);
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(path + module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(path + module + "/infrastructure/persistence/hibernate/" + file);
            }
        }

        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private String[] subdirectoriesFor(String path) {
        String[] files =  new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:mooc;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"); // Base de datos en memoria H2. Modifica según tu necesidad
        dataSource.setUsername("sa"); // nombre de usuario por defecto en H2
        dataSource.setPassword(""); // contraseña vacía por defecto en H2

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
            = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        //podemos hacerlo con xml, pero ahora no se recomienda, se dice que es un antipatron dentro del mundo de spring: aunque yo he utilizado esto en el properties
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "create");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");

        return hibernateProperties;
    }
}

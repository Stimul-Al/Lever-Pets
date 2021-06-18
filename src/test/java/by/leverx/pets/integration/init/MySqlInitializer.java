package by.leverx.pets.integration.init;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

/**
 *
 * @author aliaksei.babashau
 */
public class MySqlInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final DockerImageName DOCKER_IMAGE_NAME = DockerImageName.parse("mysql:latest");

    @Container
    private static final MySQLContainer<?> MYSQL = new MySQLContainer<>(DOCKER_IMAGE_NAME);

    static {
        MYSQL.start();
    }

    @Override public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + MYSQL.getJdbcUrl(),
                "spring.datasource.username=" + MYSQL.getUsername(),
                "spring.datasource.password=" + MYSQL.getPassword(),
                "spring.liquibase.url=" + MYSQL.getJdbcUrl(),
                "spring.liquibase.user=" + MYSQL.getUsername(),
                "spring.liquibase.password=" + MYSQL.getPassword(),
                "spring.liquibase.change-log=classpath:db/liquibase/master.xml",
                "spring.liquibase.enabled=true"

        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}
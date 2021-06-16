package by.leverx.pets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 *
 * @author aliaksei.babashau
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(generateApiInfo())
                .select()
                .apis(basePackage("by.leverx.pets.controller"))
                .build();
    }

    private ApiInfo generateApiInfo() {
        return new ApiInfoBuilder()
                .title("Pets api")
                .description("Api allows you to control the system")
                .version("1.0")
                .build();
    }
}

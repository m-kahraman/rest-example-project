package tr.com.rest.example.restuserservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfig {

	/**
	 * Swagger Arayüzüne Erişim
	 *	Uygulamanı çalıştırdıktan sonra aşağıdaki URL'lere gidebilirsin:
	 *
	 *	Swagger UI:
	 * -> http://localhost:8080/swagger-ui/
	 *
	 * OpenAPI JSON:
	 *	-> http://localhost:8080/v3/api-docs
	 * 
	 */
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) // OpenAPI 3.0
                .select()
                .apis(RequestHandlerSelectors.basePackage("tr.com.rest.example.restuserservice.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}

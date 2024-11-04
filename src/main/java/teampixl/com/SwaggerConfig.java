package teampixl.com;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PXIL-POS REST API")
                        .description("Welcome to the PIXL-POS API Service (!!!NOT FOR PRODUCTION!!!)")
                        .version("0.0")
                        .contact(new Contact()
                                .name("PIXL-API GitHub")
                                .url("https://github.com/TEAM-PIXL/PIXL-POS")
                                .email("team-pixl@outlook.com"))
                        .license(new License()
                                .name("Apache License Version 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}



package teampixl.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;
/*=========================================================================================================================================
TO-DO:
- Security access scheme for API over network body.

==========================================================================================================================================*/
@Configuration
public class SecurityConfig {

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger_ui/**",
            "/configuration/ui",
            "/swagger-resources/**",
            "/swagger-resources",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/**",
            "/api/users/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(SWAGGER_WHITELIST).permitAll()
                                .anyRequest().authenticated()
                )
                .cors(withDefaults());
        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
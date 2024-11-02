package teampixl.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PixlPosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixlPosApplication.class, args);
    }
}

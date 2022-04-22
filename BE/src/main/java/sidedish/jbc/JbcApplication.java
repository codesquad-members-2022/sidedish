package sidedish.jbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class JbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbcApplication.class, args);
	}

}

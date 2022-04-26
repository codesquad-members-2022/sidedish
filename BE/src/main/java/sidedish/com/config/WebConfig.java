package sidedish.com.config;

import java.util.Map;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		Map<String, String> envs = System.getenv();
		String awsIp = "http://" + envs.get("AWS_IP");
		String localIp = "http://" + envs.get("LOCAL_IP");

		registry.addMapping("/**")
			.allowedOrigins(localIp, awsIp);
	}
}

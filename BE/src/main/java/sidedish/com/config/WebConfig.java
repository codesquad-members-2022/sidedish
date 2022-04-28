package sidedish.com.config;

import java.util.Map;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sidedish.com.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		Map<String, String> envs = System.getenv();
		String awsIp = "http://" + envs.get("AWS_IP");
		String localIp = "http://" + envs.get("LOCAL_IP");
		String dnsName = envs.get("DNS_NAME");

		registry.addMapping("/**")
			.allowedOrigins(localIp, awsIp, dnsName);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
			.addPathPatterns("/api/products/*/order");
	}
}

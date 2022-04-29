package sidedish.jbc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sidedish.jbc.domain.convertor.MenuTypeConvertor;
import sidedish.jbc.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final LoginCheckInterceptor loginCheckInterceptor;
	private final MenuTypeConvertor menuTypeConvertor;

	public WebConfig(LoginCheckInterceptor loginCheckInterceptor,
		MenuTypeConvertor menuTypeConvertor) {
		this.loginCheckInterceptor = loginCheckInterceptor;
		this.menuTypeConvertor = menuTypeConvertor;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(menuTypeConvertor);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginCheckInterceptor)
			.order(1)
			.addPathPatterns("/menus", "/menus/detail/**");
	}
}

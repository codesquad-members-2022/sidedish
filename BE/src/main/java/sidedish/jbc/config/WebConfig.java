package sidedish.jbc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sidedish.jbc.domain.convertor.MenuTypeConvertor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final MenuTypeConvertor menuTypeConvertor;

	public WebConfig(MenuTypeConvertor menuTypeConvertor) {
		this.menuTypeConvertor = menuTypeConvertor;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(menuTypeConvertor);
	}
}

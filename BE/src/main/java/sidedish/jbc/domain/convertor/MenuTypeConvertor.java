package sidedish.jbc.domain.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sidedish.jbc.domain.MenuType;

@Component
public class MenuTypeConvertor implements Converter<String, MenuType> {

	@Override
	public MenuType convert(String source) {
		return MenuType.valueOf(source.toUpperCase());
	}
}

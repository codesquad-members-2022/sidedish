package sidedish.jbc.domain.convertor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sidedish.jbc.domain.MenuType;

@Component
public class MenuTypeConvertor implements Converter<String, MenuType> {

	@Override
	public MenuType convert(String source) {
		System.out.println("여기까지오나");
		return MenuType.valueOf(source.toUpperCase());
	}
}

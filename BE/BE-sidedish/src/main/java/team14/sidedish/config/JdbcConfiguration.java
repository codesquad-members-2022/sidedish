package team14.sidedish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import team14.sidedish.menu.Menu;

@Configuration
public class JdbcConfiguration extends AbstractJdbcConfiguration {
	@Override
	public JdbcCustomConversions jdbcCustomConversions() {
		return new JdbcCustomConversions(List.of(
			EnumToStringConverter.INSTANCE, StringToEnumFactory.INSTANCE
		));
	}

	@WritingConverter
	enum EnumToStringConverter implements Converter<Menu.Category, String> {
		INSTANCE;

		@Override
		public String convert(Menu.Category source) {
			return source.getType();
		}
	}

	@ReadingConverter
	enum StringToEnumFactory implements ConverterFactory<String, Enum> {
		INSTANCE;;

		@Override
		public <T extends Enum> Converter<String, T> getConverter(Class<T> aClass) {
			return new StringToEnum<T>(aClass);
		}

		@RequiredArgsConstructor
		private static class StringToEnum<T extends Enum> implements Converter<String, T> {
			private final Class<T> enumType;

			@Override
			public T convert(String s) {
				return Objects.isNull(s) ? null : (T)Menu.Category.from(s);
			}
		}
	}
}

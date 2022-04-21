package com.example.be.config;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiV1() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(this.apiInfo())
			.useDefaultResponseMessages(false)
			.select()
			.apis(RequestHandlerSelectors.
				basePackage("com.example.be.controller"))
			.paths(PathSelectors.ant("/api/dishes/**")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
			"Sidedish Project",
			"코드스쿼드 2주차 팀 프로젝트 API 명세서입니다.",
			"0.0.1",
			"http://3.39.42.204/api/dishes/",
			new Contact("Contact Me", "https://codesquad-members.slack.com/archives/C03BU6F4F5H", "devdonggilee@gmail.com"),
			"codesquad Licenses",
			"https://codesquad-members.slack.com/archives/C03BU6F4F5H",
			new ArrayList<>()
		);
	}
}

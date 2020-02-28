/*
* (C) Copyright 2019
* @Author BamBu_Vn
* @Date Oct 27, 2019
* @Version 1.0
*/
package teacherweb.com.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("teacherweb.com.controller")).paths(PathSelectors.any()).build()
				.apiInfo(metaData()).globalOperationParameters(operationParameters())
				.tags(new Tag("account", ""));
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Teacher Web").description("").version("").license("").licenseUrl("").build();
	}

	private List<Parameter> operationParameters() {
		return Lists.newArrayList(new ParameterBuilder().name(HttpHeaders.AUTHORIZATION)
				.modelRef(new ModelRef("string")).parameterType("header").required(Boolean.FALSE).build());
	}
}

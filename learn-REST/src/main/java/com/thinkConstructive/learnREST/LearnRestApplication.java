package com.thinkConstructive.learnREST;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class LearnRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnRestApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/cloudvendor/*"))
				.apis(RequestHandlerSelectors.basePackage("com.thinkConstructive.learnREST"))
				.build()
				.apiInfo(apiCustomData());
	}

	private ApiInfo apiCustomData(){
		return new ApiInfo(
			"Cloud Vendor API Application",
			"Cloud Vendor Documentation",
			"1.0",
			"Cloud vendor service terms",
			new Contact("Esha Puri", "http://thinkconstructive.com", "contact@thinkConstructive.com"),
			"Think constructive license",
			"http://thinkconstructive.com",
			Collections.emptyList()
			);
	}

}

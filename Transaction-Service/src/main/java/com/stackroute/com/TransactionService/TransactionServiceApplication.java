package com.stackroute.com.TransactionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableWebMvc
public class TransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiceApplication.class, args);
	}
	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().paths(PathSelectors.ant("/transaction-service/**"))
				.apis(RequestHandlerSelectors.basePackage("com.stackroute.com.TransactionService"))
				.build()
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails(){
		Contact contact = new Contact("kireeti",null,"kireeti@gmail.com");
		ApiInfo apiInfo = new ApiInfo("Transaction Service API","Deals with transactions","1.0","kireeti@gmail.com","kireeti",null,null);
		return apiInfo;
	}
}

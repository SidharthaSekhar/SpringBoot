package com.sid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProductMsApplication {
	
	@Value("${version}")
    private String version; 
	
	public static void main(String[] args) {
		SpringApplication.run(ProductMsApplication.class, args);
	}
	@SuppressWarnings({ "unused", "deprecation" })
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("Product MS")
                .description(
                        "This API documentation is for all Restful Services of ProductMS.<p>" +
                                "This Web service is implemented using SpringBoot and Swagger for the auto-generated documentation.")                       
                .contact("Sidhartha(mailto:sidharthasekhar.sahu@gmail.com) 9538251261")                       
                .version(version)
                .build();
    }
}

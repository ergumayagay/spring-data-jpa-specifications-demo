package org.emil.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJpaSpecificationsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaSpecificationsDemoApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.directModelSubstitute(LocalDate.class, java.sql.Date.class)
					.select()
					.apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.any())	
					.build();
	}
}


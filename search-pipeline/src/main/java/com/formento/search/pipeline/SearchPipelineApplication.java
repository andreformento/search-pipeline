package com.formento.search.pipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SearchPipelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchPipelineApplication.class, args);
	}
}

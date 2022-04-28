package com.br.vitor.gamesapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class GamesApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesApiRestApplication.class, args);
	}

}

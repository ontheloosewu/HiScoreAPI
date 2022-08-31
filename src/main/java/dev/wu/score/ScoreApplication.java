package dev.wu.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.wu"})
@EntityScan(basePackages = {"dev.wu.entities"})
@EnableJpaRepositories(basePackages = {"dev.wu.repos"})
public class ScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreApplication.class, args);
	}

}

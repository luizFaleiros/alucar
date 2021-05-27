package br.com.alucar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("br.com.alucar")
@EnableJpaRepositories
public class AlucarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlucarApplication.class, args);
	}

}

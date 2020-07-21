package br.sc.senai.sasalesinventorybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("br.sc.senai.controller")
@EntityScan("br.sc.senai.model")
@EnableJpaRepositories("br.sc.senai.repository")
public class SaSalesinventoryBackendApplication {

	public static void main(String[] args){
	SpringApplication.run(SaSalesinventoryBackendApplication.class, args);
	}

}

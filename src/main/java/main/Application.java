package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import author.controller.AuthorController;
import author.exceptionhandler.AuthorRequestExceptionHandler;
import author.repository.AuthorRepository;
import author.service.AuthorService;

@SpringBootApplication
@ComponentScan(basePackageClasses = { AuthorController.class, AuthorService.class, AuthorRepository.class,
		AuthorRequestExceptionHandler.class })
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

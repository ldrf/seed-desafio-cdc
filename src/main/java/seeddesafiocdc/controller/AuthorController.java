package seeddesafiocdc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import seeddesafiocdc.model.Author;
import seeddesafiocdc.payload.AuthorRequest;
import seeddesafiocdc.validator.ForbidsDuplicateAuthorMailValidator;


@RestController
@RequestMapping("/author")
//Total de carga da classe = 3
public class AuthorController {

	private final EntityManager em;

	private final ForbidsDuplicateAuthorMailValidator forbidsDuplicateDuplicateAuthorMailValidator;

	public AuthorController(final EntityManager em,
			final ForbidsDuplicateAuthorMailValidator forbidsDuplicateDuplicateAuthorMailValidator) {

		this.em = em;
		this.forbidsDuplicateDuplicateAuthorMailValidator = forbidsDuplicateDuplicateAuthorMailValidator;
	}

	// Método usado para log no request que chego ao controler.
	// A idéia é realizar configurações adicionais que precisam
	// ser colocadas na execução da request relativa a esse
	// controler.
	@InitBinder
	public void init(final WebDataBinder binder) {
		// 1
		binder.addValidators(forbidsDuplicateDuplicateAuthorMailValidator);
	}

	@PostMapping(value = "/create")
	@Transactional
	// 1
	// total de carga do metodo = 2
	public ResponseEntity<String> createAutor(@Valid @RequestBody final AuthorRequest authorRequest) {
		// 2
		Author author = authorRequest.toModel();
		em.persist(author);
		return new ResponseEntity<>("Author is create", HttpStatus.CREATED);
	}

}

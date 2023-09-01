package seeddesafiocdc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import seeddesafiocdc.model.Author;
import seeddesafiocdc.payload.AuthorRequest;

@RestController
@RequestMapping("/author")
//Total de carga da classe = 2
public class AuthorController {

	private final EntityManager em;

	public AuthorController(final EntityManager em) {
		this.em = em;
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

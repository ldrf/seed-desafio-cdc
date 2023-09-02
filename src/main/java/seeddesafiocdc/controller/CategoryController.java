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
import seeddesafiocdc.model.Category;
import seeddesafiocdc.payload.CategoryRequest;
import seeddesafiocdc.validator.ForbidsDuplicateCategoryNameValidator;

@RestController
@RequestMapping("/category")
//total de carga da classe = 3
public class CategoryController {

	private final EntityManager em;
	private final ForbidsDuplicateCategoryNameValidator forbidsDuplicateCategoryNameValidator;

	public CategoryController(final EntityManager em,
			final ForbidsDuplicateCategoryNameValidator forbidsDuplicateCategoryNameValidator) {
		this.em = em;
		this.forbidsDuplicateCategoryNameValidator = forbidsDuplicateCategoryNameValidator;
	}

	@InitBinder
	// total d ecarga do metodo = 1
	public void init(final WebDataBinder binder) {
		binder.addValidators(forbidsDuplicateCategoryNameValidator);
	}

	@PostMapping(value = "/create")
	@Transactional
	// total de carga do metodo = 2
	public ResponseEntity<String> createCategory(@Valid @RequestBody final CategoryRequest request) {
		// 2
		Category category = request.toModel();
		em.persist(category);
		return new ResponseEntity<>("Category " + request.getName() + " was created", HttpStatus.CREATED);
	}

}

package seeddesafiocdc.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import seeddesafiocdc.model.Category;
import seeddesafiocdc.payload.CategoryRequest;
import seeddesafiocdc.repository.CategoryRepository;

@Component
public class ForbidsDuplicateCategoryNameValidator implements Validator {

	private final CategoryRepository categoryRepository;

	public ForbidsDuplicateCategoryNameValidator(final CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public boolean supports(final Class<?> clazz) {
		return CategoryRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors) {
		// Se nao existir nenhum erro antes, verificar a nossa validação
		if (!errors.hasErrors()) {
			CategoryRequest request = (CategoryRequest) target;
			Optional<Category> optionalAuthor = categoryRepository.findByName(request.getName());
			optionalAuthor.ifPresent(
					author -> errors.rejectValue("name", null, "there is another category with " + request.getName()));
		}

	}

}

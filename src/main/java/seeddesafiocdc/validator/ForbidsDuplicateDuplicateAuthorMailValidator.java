package seeddesafiocdc.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import seeddesafiocdc.model.Author;
import seeddesafiocdc.payload.AuthorRequest;
import seeddesafiocdc.repository.AuthorRepository;

@Component
public class ForbidsDuplicateDuplicateAuthorMailValidator implements Validator {

	private final AuthorRepository authorRepository;

	public ForbidsDuplicateDuplicateAuthorMailValidator(final AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public boolean supports(final Class<?> clazz) {
		return AuthorRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors) {
		// Se nao existir nenhum erro antes, verificar a nossa validação
		if (!errors.hasErrors()) {
			AuthorRequest request = (AuthorRequest) target;
			Optional<Author> optionalAuthor = authorRepository.findByEmail(request.getEmail());
			optionalAuthor.ifPresent(author -> errors.rejectValue("email", null,
					"there is another registered email with " + request.getEmail()));
		}

	}

}

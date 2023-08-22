package author.validation;

import author.constant.AuthorConstant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AuthorDescriptionValidator implements ConstraintValidator<AuthorDescriptionValidation, String> {

	@Override
	public boolean isValid(final String actualDescription, final ConstraintValidatorContext context) {
		return actualDescription.length() <= AuthorConstant.MAX_LENGTH_AUTHOR_DESCRIPTION;
	}

}

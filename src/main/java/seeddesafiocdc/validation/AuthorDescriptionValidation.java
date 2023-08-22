package seeddesafiocdc.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = AuthorDescriptionValidator.class)
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorDescriptionValidation {
	String message() default "The field description exceeds a maximum of 400 characters.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

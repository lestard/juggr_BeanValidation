package de.saxsys.beanvalidation.example.bv;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



@Min(15)
@Max(70)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface ValidSchuhgroesse {
	String message() default "invalid Schuhgröße";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

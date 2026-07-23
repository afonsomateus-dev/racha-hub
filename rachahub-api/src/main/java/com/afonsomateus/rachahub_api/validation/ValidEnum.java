package com.afonsomateus.rachahub_api.validation;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EnumValidator.class)
public @interface ValidEnum {
	Class<? extends Enum<?>> enumClass();
	String message() default "Invalid value. Must be one of the accepted enum constants.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

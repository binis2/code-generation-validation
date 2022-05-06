package net.binis.codegen.annotations;

import net.binis.codegen.annotation.CodeAnnotation;
import net.binis.codegen.annotation.validation.Validate;
import net.binis.codegen.validation.validator.RegExValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@CodeAnnotation
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Validate(value = RegExValidator.class, params = ValidateJavaScriptInjection.REGEX, message = "(%s) Injection attempt!")
public @interface ValidateJavaScriptInjection {
    String REGEX = "^((?!<).)*$";
}

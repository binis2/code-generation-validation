package net.binis.codegen.annotation.validation;

import net.binis.codegen.annotation.CodeAnnotation;
import net.binis.codegen.validation.annotation.ValidateLambda;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@CodeAnnotation
@Target({ ElementType.METHOD, ElementType.TYPE_USE })
@ValidateLambda("net.binis.codegen.Validators::test")
public @interface ValidateTest {

    String message() default "{field} test invalid value!";
}

package net.binis.codegen.annotation.validation;

import net.binis.codegen.validation.annotation.SanitizeLambda;
import net.binis.codegen.annotation.CodeAnnotation;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@CodeAnnotation
@Target({ ElementType.METHOD, ElementType.TYPE_USE })
@SanitizeLambda("net.binis.codegen.Validators::test")
public @interface SanitizeTest {

    String message() default "{field} test invalid value!";
}

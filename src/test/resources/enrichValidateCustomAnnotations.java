package net.binis.codegen;

import lombok.Data;
import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.*;

import java.util.List;
import java.util.Set;

@CodePrototype(
        classSetters = false,
        enrichers = {ModifierEnricher.class, ValidationEnricher.class})
public interface TestPrototype {
    @SanitizeReplace("\\s+")
    @SanitizeTrim
    String title();

    @SanitizeReplace(with = "_", value = "\\s+")
    @ValidateEmail
    String email();

    @ValidateNull
    List<Long> list();

    @ValidateRegEx(message = "Test", expression = "^$")
    Set<Long> set();

    @ValidateRange(min = 0, max = 10)
    int amount();

    @ValidateNotBlank
    @SanitizeLowerCase
    @SanitizeUpperCase
    String field();

    @ValidateLambda("v -> true")
    @SanitizeLambda("v -> v")
    String field1();

    @Data
    abstract class ClassAnnotations {

    }

}
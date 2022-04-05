package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.validation.Sanitize;
import net.binis.codegen.annotation.validation.Validate;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.ValidateLength;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.validator.NullValidator;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CodePrototype(enrichers = {ModifierEnricher.class, ValidationEnricher.class})
public interface TestPrototype {
    @ValidateLength(min = 10, minMessage = "Must be longer than %4$d!", maxMessage = "Must be shorter than %3$d!")
    @Sanitize(TrimSanitizer.class)
    String title();

    @Validate(NullValidator.class)
    List<Long> list();

    @Validate(value = NullValidator.class, params = {"asd", "fgh"}, message = "test")
    Set<Long> set();

    @Validate(value = NullValidator.class, params = {}, message = "test")
    Map<Long, String> map();
}
package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.ValidateEmail;

@CodePrototype(enrichers = ValidationEnricher.class)
public interface TestPrototype {

    @ValidateEmail
    long title();

}
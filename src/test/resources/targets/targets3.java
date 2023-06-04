package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.ValidateRegEx;

@CodePrototype(enrichers = ValidationEnricher.class)
public interface TestPrototype {

    @ValidateRegEx(expression = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", targets = String.class)
    long title();

}
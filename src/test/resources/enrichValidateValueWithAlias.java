package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.CreatorModifierEnricher;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.*;

@CodePrototype(enrichers = {ValidationEnricher.class})
public interface TestPrototype {

    @ValidateLength(3)
    String field();

    @ValidateLength(value = 3)
    String field1();

}
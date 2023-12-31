package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.CreatorModifierEnricher;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.ExecuteLambda;
import net.binis.codegen.validation.annotation.SanitizeTrim;
import net.binis.codegen.validation.annotation.SanitizeUpperCase;

@CodePrototype(enrichers = {ModifierEnricher.class, ValidationEnricher.class})
public interface TestPrototype {

    @ExecuteLambda("value -> { if ({entity}.originalAmount == null) { {entity}.originalAmount = value; }}")
    double amount();

    Double originalAmount();

}
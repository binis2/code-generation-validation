package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.validation.Sanitize;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;

@CodePrototype(enrichers = {ModifierEnricher.class, ValidationEnricher.class})
public interface TestPrototype {

    @Sanitize(TrimSanitizer.class)
    String title();

}
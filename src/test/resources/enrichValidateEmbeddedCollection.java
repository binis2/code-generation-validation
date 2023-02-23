package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.ValidateNotBlank;
import net.binis.codegen.validation.annotation.ValidateNull;

import java.util.List;

@CodePrototype(enrichers = {ValidationEnricher.class, ModifierEnricher.class})
public interface TestPrototype {

    @ValidateNull
    String field();

    @ValidateNull
    List<@ValidateNull TestPrototype> list();

}
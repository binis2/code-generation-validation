package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.validation.Validate;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.validator.NullValidator;

import java.util.List;

@CodePrototype(enrichers = {ModifierEnricher.class, ValidationEnricher.class}, mixInClass = TestPrototype.class)
public interface MixInPrototype extends TestPrototype {

    @Validate(NullValidator.class)
    List<Long> list();

}
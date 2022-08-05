package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.intf.Prototypable;
import net.binis.codegen.validation.annotation.SanitizeTrim;
import net.binis.codegen.validation.annotation.ValidateRange;

@CodePrototype(interfaceSetters = false, classSetters = false, enrichers = {ModifierEnricher.class, ValidationEnricher.class})
public interface SubModifyPrototype extends Prototypable<SubModifyPrototype> {
    @SanitizeTrim
    String subtitle();

    @ValidateRange(min = 0, max = 10)
    double subAmount();
}
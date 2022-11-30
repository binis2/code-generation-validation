package net.binis.codegen;

import net.binis.codegen.annotation.CodeConstant;
import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.SanitizeLength;
import net.binis.codegen.validation.annotation.ValidateLength;

import static net.binis.codegen.constants.Constants.STATIC_MAX_LENGTH;
import net.binis.codegen.constants.Constants;

@CodePrototype(enrichers = ValidationEnricher.class)
public interface TestPrototype {

    @ValidateLength(value = Constants.STATIC_MAX_LENGTH * STATIC_MAX_LENGTH, maxMessage = Constants.STATIC_TEXT + "!")
    String calculated();

    @ValidateLength(10 * Constants.STATIC_MAX_LENGTH)
    @SanitizeLength(10 * STATIC_MAX_LENGTH)
    String calculated2();
}
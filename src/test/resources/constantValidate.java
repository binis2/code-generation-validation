package net.binis.codegen;

import net.binis.codegen.annotation.CodeConstant;
import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.ValidateLength;

import static net.binis.codegen.constants.Constants.STATIC_MAX_LENGTH;
import net.binis.codegen.constants.Constants;

@CodePrototype(enrichers = ValidationEnricher.class)
public interface TestPrototype {

    static final int MAX_LENGTH = 100;

    @CodeConstant(forInterface = true)
    static final int LENGTH = 1000;

    @ValidateLength(value = 10 * 10, maxMessage = Constants.STATIC_TEXT + "!")
    String calculated();

    @ValidateLength(MAX_LENGTH)
    String title();

    @ValidateLength(TestPrototype.MAX_LENGTH)
    String subtitle();

    @ValidateLength(TestPrototype.LENGTH)
    String other();

    @ValidateLength(STATIC_MAX_LENGTH)
    String compiledTitle();

    @ValidateLength(Constants.STATIC_MAX_LENGTH)
    String compiledSubtitle();

}
package net.binis.codegen.validate.length;

import net.binis.codegen.annotation.builder.CodeValidationBuilder;
import net.binis.codegen.options.ValidationFormOption;
import net.binis.codegen.validation.annotation.ValidateLength;
import net.binis.codegen.validation.annotation.ValidateNull;
import net.binis.codegen.validation.annotation.ValidateRange;

import java.util.List;

@CodeValidationBuilder
public interface TestPrototype {

    @ValidateLength(min = 3, max = 4)
    int value();

    @ValidateLength(min = 3, value = 4)
    int value2();

}
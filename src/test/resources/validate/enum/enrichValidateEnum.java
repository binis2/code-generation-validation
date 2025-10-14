package net.binis.codegen.validateenum;

import net.binis.codegen.PlainCodeEnum;
import net.binis.codegen.PlainEnum;
import net.binis.codegen.annotation.builder.CodeValidationBuilder;
import net.binis.codegen.validation.annotation.ValidateEnum;

@CodeValidationBuilder
public interface TestEnumPrototype {

    @ValidateEnum
    PlainEnum plain();

    @ValidateEnum
    PlainCodeEnum codeEnum();

    @ValidateEnum(cls = PlainEnum.class)
    String str();

    @ValidateEnum(cls = PlainCodeEnum.class)
    String str2();

}
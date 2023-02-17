package net.binis.codegen.validate.range;

import net.binis.codegen.annotation.Default;
import net.binis.codegen.annotation.builder.CodeRequest;
import net.binis.codegen.annotation.builder.CodeValidationBuilder;
import net.binis.codegen.annotation.validation.Sanitize;
import net.binis.codegen.annotation.validation.Validate;
import net.binis.codegen.options.GenerateOpenApiAlwaysOption;
import net.binis.codegen.options.HiddenCreateMethodOption;
import net.binis.codegen.options.ValidationFormOption;
import net.binis.codegen.validation.annotation.ValidateEmail;
import net.binis.codegen.validation.annotation.ValidateLength;
import net.binis.codegen.validation.annotation.ValidateNull;
import net.binis.codegen.validation.annotation.ValidateRange;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.validator.NullValidator;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CodeValidationBuilder(options = ValidationFormOption.class)
public interface TestPrototype {

    @ValidateNull
    @ValidateRange(min=0, max = 1000, minMessage = "min %2$d(%3$d)", maxMessage = "max %2$d(%4$d)")
    @ValidateLength(min = 1)
    int value();

    @ValidateNull
    List<@ValidateNull @ValidateRange(min=0, max = 1000, minMessage = "minC %2$d(%3$d)", maxMessage = "maxC %2$d(%4$d)") @ValidateLength(min = 1) Integer> list();


}
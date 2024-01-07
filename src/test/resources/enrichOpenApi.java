package net.binis.codegen;

import net.binis.codegen.annotation.Default;
import net.binis.codegen.annotation.EnumPrototype;
import net.binis.codegen.annotation.builder.CodeRequest;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.annotation.validation.Sanitize;
import net.binis.codegen.annotation.validation.Validate;
import net.binis.codegen.options.GenerateOpenApiIfAvailableOption;
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

@CodeRequest(options = {ValidationFormOption.class, HiddenCreateMethodOption.class, GenerateOpenApiIfAvailableOption.class})
public interface TestPrototype {
    @Default("\"asd\"")
    @ValidateLength(min = 10, minMessage = "Must be longer than %4$d!", maxMessage = "Must be shorter than %3$d!")
    @Sanitize(TrimSanitizer.class)
    @ValidateEmail
    String title();

    @Default(value = "100")
    @ValidateRange(min = Integer.MIN_VALUE, max = Integer.MAX_VALUE - 5)
    int number();

    @ValidateNull
    List<Long> list();

    @Validate(value = NullValidator.class, params = {"asd", "fgh"}, message = "test")
    Set<Long> set();

    @Validate(value = NullValidator.class, params = {}, message = "another test")
    Map<Long, String> map();

    @ValidateNull
    SubPrototype sub();

    @ValidateNull
    OpenApiEnumPrototype type();

    GenerationStrategy compiled();
    @CodeRequest(options = {ValidationFormOption.class, HiddenCreateMethodOption.class, GenerateOpenApiIfAvailableOption.class})
    interface SubPrototype {

        @ValidateNull
        String value();

    }

    @EnumPrototype
    enum OpenApiEnumPrototype {
        ONE,
        TWO
    }

}
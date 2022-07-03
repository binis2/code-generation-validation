package net.binis.codegen;

import net.binis.codegen.annotation.Default;
import net.binis.codegen.annotation.builder.CodeRequest;
import net.binis.codegen.annotation.validation.Sanitize;
import net.binis.codegen.annotation.validation.Validate;
import net.binis.codegen.options.GenerateOpenApiAlwaysOption;
import net.binis.codegen.options.HiddenCreateMethodOption;
import net.binis.codegen.options.ValidationFormOption;
import net.binis.codegen.validation.annotation.ValidateEmail;
import net.binis.codegen.validation.annotation.ValidateLength;
import net.binis.codegen.validation.annotation.ValidateNull;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.validator.NullValidator;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CodeRequest(options = {ValidationFormOption.class, HiddenCreateMethodOption.class, GenerateOpenApiAlwaysOption.class})
public interface TestPrototype {
    @Default("\"asd\"")
    @ValidateLength(min = 10, minMessage = "Must be longer than %4$d!", maxMessage = "Must be shorter than %3$d!")
    @Sanitize(TrimSanitizer.class)
    @ValidateEmail
    String title();

    @ValidateNull
    List<Long> list();

    @Validate(value = NullValidator.class, params = {"asd", "fgh"}, message = "test")
    Set<Long> set();

    @Validate(value = NullValidator.class, params = {}, message = "another test")
    Map<Long, String> map();

    @ValidateNull
    SubPrototype sub();

    @CodeRequest(options = {ValidationFormOption.class, HiddenCreateMethodOption.class, GenerateOpenApiAlwaysOption.class})
    interface SubPrototype {

        @ValidateNull
        String value();

    }

}
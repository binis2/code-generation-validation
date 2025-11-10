package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.Ignore;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.options.ExposeValidateMethodOption;
import net.binis.codegen.options.ValidationFormOption;
import net.binis.codegen.validation.annotation.ExecuteAllButLambda;
import net.binis.codegen.validation.annotation.SanitizeTrim;
import net.binis.codegen.validation.annotation.ValidateNull;

import java.util.*;

@CodePrototype(enrichers = {ModifierEnricher.class, ValidationEnricher.class}, options = {ValidationFormOption.class, ExposeValidateMethodOption.class})
@Ignore(forValidation = true)
public interface TestPrototype {

    @ValidateNull
    Map<String, Object> map();

    @Ignore(forValidation = true)
    @ValidateNull
    List<@ValidateNull String> list();

    Set<@SanitizeTrim String> set();

}
package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.annotation.Ignore;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.options.ExposeValidateMethodOption;
import net.binis.codegen.options.ValidationFormOption;
import net.binis.codegen.validation.annotation.ExecuteAllButLambda;
import net.binis.codegen.validation.annotation.SanitizeTrim;
import net.binis.codegen.validation.annotation.ValidateNotEmpty;
import net.binis.codegen.validation.annotation.ValidateNull;

import java.util.*;

@CodePrototype(enrichers = {ModifierEnricher.class, ValidationEnricher.class}, options = {ValidationFormOption.class, ExposeValidateMethodOption.class})
@Ignore(forValidation = true)
public interface TestPrototype {

    @ValidateNotEmpty
    Map<String, Object> map();

    @ValidateNotEmpty
    List<String> list();

    @ValidateNotEmpty
    Set<String> set();

    @ValidateNotEmpty
    int[] array();

}
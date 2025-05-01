package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.ModifierEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.ExecuteAllButLambda;
import net.binis.codegen.validation.annotation.SanitizeTrim;
import net.binis.codegen.validation.annotation.ValidateNull;

import java.util.*;

@CodePrototype(enrichers = {ModifierEnricher.class, ValidationEnricher.class})
public interface TestPrototype {

    double amount();

    Double originalAmount();

    @ExecuteAllButLambda("v -> {entity}.counter++")
    int counter();

    @ValidateNull
    Map<String, Object> map();

    List<@ValidateNull String> list();

    Set<@SanitizeTrim String> set();

}
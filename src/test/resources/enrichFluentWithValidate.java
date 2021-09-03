package net.binis.codegen;

import net.binis.codegen.annotation.CodePrototype;
import net.binis.codegen.enrich.FluentEnricher;
import net.binis.codegen.enrich.ValidationEnricher;
import net.binis.codegen.validation.annotation.SanitizeTrim;
import net.binis.codegen.validation.annotation.ValidateNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CodePrototype(enrichers = {FluentEnricher.class, ValidationEnricher.class}, interfaceSetters = false, classSetters = false)
public interface TestPrototype {

    @ValidateNull
    @SanitizeTrim
    String title();
    List<Long> list();
    Set<Long> set();
    Map<Long, String> map();

}
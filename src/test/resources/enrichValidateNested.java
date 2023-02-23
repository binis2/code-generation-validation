package net.binis.codegen;

import net.binis.codegen.annotation.builder.CodeBuilder;
import net.binis.codegen.annotation.builder.CodeRequest;
import net.binis.codegen.validation.annotation.ValidateNull;

import java.util.List;

@CodeBuilder
interface TestPrototype {
    List<Item> list();
    @CodeRequest
    interface Item {
        @ValidateNull
        String value();
    }
}
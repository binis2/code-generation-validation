package net.binis.codegen;

import net.binis.codegen.enrich.annotation.Sanitizer;

public class Validators {

    @Sanitizer(message = "{field} test invalid value!")
    public static String test(String test) {
        return test;
    }

}
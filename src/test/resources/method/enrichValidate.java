package net.binis.codegen;

import net.binis.codegen.enrich.annotation.Validator;

public class Validators {

    @Validator(message = "{field} test invalid value!")
    public static boolean test(String test) {
        return true;
    }

}
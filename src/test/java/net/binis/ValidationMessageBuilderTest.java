package net.binis;

import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.validation.message.ValidationMessageBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationMessageBuilderTest {

    @BeforeEach
    void before() {
        CodeFactory.create(ValidationMessageBuilder.class).cleanUp();
    }
    @Test
    void test() {
        var msg = ValidationMessageBuilder.message("field", "value", new Object[] {1, 2L, 3.0, 4.0f}, "Field '{field}' with value '{value}' with params - [{params[0]},{params[1]},{params[2]},{params[3]},{params[4]},{params[5]}]");

        assertEquals("Field 'field' with value 'value' with params - [1,2,3.0,4.0,{params[4]},{params[5]}]", msg);
    }

}

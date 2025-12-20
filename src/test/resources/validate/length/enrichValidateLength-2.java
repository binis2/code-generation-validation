package net.binis.codegen.validate.length;

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.exception.ValidationException;
import net.binis.codegen.test.TestExecutor;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
public class Execute extends TestExecutor {

    @Override
    public boolean execute() {

        try {
            Test.create().value(-1).done();
            Test.create().value2(-1).done();
            throw new UnsupportedOperationException();
        } catch (ValidationException e) {
            assertEquals("Value (-1) for field 'value' is shorter than 3!", e.getMessage());
        }

        try {
            Test.create().value(10010).done();
            Test.create().value2(10010).done();
            throw new UnsupportedOperationException("1");
        } catch (ValidationException e) {
            assertEquals("Value (10010) for field 'value' is longer than 4!", e.getMessage());
        }

        try {
            Test.create().value3("3999").done();
            Test.create().value3("123456").done();
            throw new UnsupportedOperationException("1");
        } catch (ValidationException e) {
            assertEquals("too long", e.getMessage());
        }


        return true;
    }
}

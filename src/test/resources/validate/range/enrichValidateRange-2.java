package net.binis.codegen.validate.range;

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
            throw new UnsupportedOperationException();
        } catch (ValidationException e) {
            assertEquals("min -1(0)", e.getMessage());
        }

        try {
            Test.create().value(1001).done();
            throw new UnsupportedOperationException("1");
        } catch (ValidationException e) {
            assertEquals("max 1001(1000)", e.getMessage());
        }

        try {
            var list = new ArrayList<Integer>();
            list.add(-1);
            list.add(1001);
            Test.create().list(list).done();
            throw new UnsupportedOperationException("2");
        } catch (ValidationException e) {
            assertEquals("minC -1(0)", e.getMessage());
        }

        try {
            Test.create().list().add(-1).done();
            throw new UnsupportedOperationException("3");
        } catch (ValidationException e) {
            assertEquals("minC -1(0)", e.getMessage());
        }

        try {
            Test.create().list().add(1001).done();
            throw new UnsupportedOperationException("4");
        } catch (ValidationException e) {
            assertEquals("maxC 1001(1000)", e.getMessage());
        }

        return true;
    }
}

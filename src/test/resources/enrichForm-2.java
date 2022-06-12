package net.binis.codegen;

import net.binis.codegen.exception.ValidationFormException;
import net.binis.codegen.test.TestExecutor;
import static org.junit.Assert.*;

public class Execute extends TestExecutor {

    @Override
    public boolean execute() {

        try {
            new TestImpl().validate();
        } catch (ValidationFormException ex) {
            System.out.println(ex.toString());
        }

        return true;
    }
}

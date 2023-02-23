/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.exception.ValidationException;
import net.binis.codegen.test.TestExecutor;
import static org.junit.jupiter.api.Assertions.*;

public class Execute extends TestExecutor {

    @Override
    public boolean execute() {

        assertThrows(ValidationException.class, () -> new TestImpl().with().list()._add(null));

        return true;
    }
}

/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.test.TestExecutor;
import static org.junit.jupiter.api.Assertions.*;

public class Execute extends TestExecutor {

    @Override
    public boolean execute() {

        var test = new TestImpl().with().title(" asd ").done();

        assertEquals("ASD", test.getTitle());

        return true;
    }
}

/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.test.TestExecutor;
import static org.junit.jupiter.api.Assertions.*;

public class Execute extends TestExecutor {

    @Override
    public boolean execute() {

        var test = new TestImpl().with()
                .amount(1000.0)
                .originalAmount(500.0)
                .list().add("1").done()
                .map().put("1", "2").done()
                .done();

        assertEquals(2, test.getCounter());

        return true;
    }
}

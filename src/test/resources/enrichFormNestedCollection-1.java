/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
public interface Test {
    List<Test.Sub> getList();
    Map<Long, Test.Sub> getMap();
    Set<Test.Sub> getSet();
    String getTitle();

    // region inner classes
    @Default("net.binis.codegen.TestImpl$SubImpl")
    public interface Sub {
        String getValue();
    }
    // endregion
}

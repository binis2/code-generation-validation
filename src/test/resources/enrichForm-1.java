/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;

@Generated(value = "TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
public interface Test {
    List<Long> getList();
    Map<Long, String> getMap();
    Set<Long> getSet();
    String getTitle();
}

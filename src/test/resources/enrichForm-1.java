/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;
import io.swagger.v3.oas.annotations.media.*;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
public interface Test {
    @Schema(name = "list", required = true)
    List<Long> getList();

    @Schema(name = "map", required = true)
    Map<Long, String> getMap();

    @Schema(name = "set", required = true)
    Set<Long> getSet();

    @Schema(name = "title", required = true)
    String getTitle();
}

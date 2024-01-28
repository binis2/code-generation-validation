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
    @ArraySchema(schema = @Schema(name = "list", required = true))
    List<Long> getList();

    @ArraySchema(schema = @Schema(name = "map"))
    Map<Long, String> getMap();

    @ArraySchema(schema = @Schema(name = "set"))
    Set<Long> getSet();

    @Schema(name = "title", defaultValue = "asd", minLength = 10)
    String getTitle();
}

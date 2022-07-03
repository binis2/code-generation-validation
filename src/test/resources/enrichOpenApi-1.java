/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;
import io.swagger.annotations.*;

@Generated(value = "TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
@ApiModel()
public interface Test {
    @ApiModelProperty(name = "list")
    List<Long> getList();

    @ApiModelProperty(name = "map")
    Map<Long, String> getMap();

    @ApiModelProperty(name = "set")
    Set<Long> getSet();

    @ApiModelProperty(name = "sub")
    Test.Sub getSub();

    @ApiModelProperty(name = "title")
    String getTitle();

    // region inner classes
    @Default("net.binis.codegen.TestImpl$SubImpl")
    @ApiModel()
    public interface Sub {
        @ApiModelProperty(name = "value")
        String getValue();
    }
    // endregion
}

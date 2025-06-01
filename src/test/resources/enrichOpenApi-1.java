/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.objects.base.enumeration.CodeEnum;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.annotation.type.GenerationStrategy;
import net.binis.codegen.annotation.Default;
import net.binis.codegen.Test.Sub;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;
import io.swagger.v3.oas.annotations.media.*;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
public interface Test {
    @Schema(name = "compiled", allowableValues = { "PROTOTYPE", "IMPLEMENTATION", "PLAIN", "NONE" }, type = "string")
    GenerationStrategy getCompiled();

    @ArraySchema(schema = @Schema(name = "list", required = true))
    List<Long> getList();

    @ArraySchema(schema = @Schema(name = "map"))
    Map<Long, String> getMap();

    @Schema(name = "number", defaultValue = "100", minimum = "Integer.MIN_VALUE", maximum = "Integer.MAX_VALUE - 5")
    int getNumber();

    @Schema(name = "Presented", description = "This is present annotation", minLength = 11, maxLength = 19, example = "example", required = true)
    String getPresent();

    @ArraySchema(schema = @Schema(name = "set"))
    Set<Long> getSet();

    @Schema(name = "sub", required = true)
    Test.Sub getSub();

    @Schema(name = "title", defaultValue = "asd", minLength = 10)
    String getTitle();

    @Schema(name = "type", required = true, allowableValues = { "ONE", "TWO" }, type = "string")
    Test.OpenApiEnum getType();

    // region inner classes
    @net.binis.codegen.annotation.Generated(by = "net.binis.codegen.TestPrototype.OpenApiEnumPrototype")
    @Default("net.binis.codegen.TestImpl$OpenApiEnumImpl")
    public interface OpenApiEnum extends CodeEnum {

        static final OpenApiEnum ONE = CodeFactory.initializeEnumValue(OpenApiEnum.class, "ONE", 0);

        static final OpenApiEnum TWO = CodeFactory.initializeEnumValue(OpenApiEnum.class, "TWO", 1);

        static OpenApiEnum valueOf(String name) {
            return CodeFactory.enumValueOf(OpenApiEnum.class, name);
        }

        static OpenApiEnum valueOf(int ordinal) {
            return CodeFactory.enumValueOf(OpenApiEnum.class, ordinal);
        }

        static OpenApiEnum[] values() {
            return CodeFactory.enumValues(OpenApiEnum.class);
        }
    }

    @Default("net.binis.codegen.TestImpl$SubImpl")
    public interface Sub {
        @Schema(name = "value", required = true)
        String getValue();
    }
    // endregion
}

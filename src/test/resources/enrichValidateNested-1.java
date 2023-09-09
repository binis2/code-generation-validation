/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import net.binis.codegen.Test.Item;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.TestImpl")
@SuppressWarnings("unchecked")
public interface Test {

    // region starters
    static Test.Modify create() {
        return (Test.Modify) EntityCreatorModifier.create(Test.class).with();
    }
    // endregion

    List<Test.Item> getList();

    Test.Modify with();

    // region inner classes
    @Default("net.binis.codegen.TestImpl$ItemImpl")
    public interface Item {
        String getValue();
    }

    interface Modify extends BaseModifier<Test.Modify, Test> {
        Modify list(List<Test.Item> list);
    }
    // endregion
}

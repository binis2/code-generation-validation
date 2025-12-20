/*Generated code by Binis' code generator.*/
package net.binis.codegen.validate.length;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.validate.length.TestPrototype", comments = "TestImpl")
@Default("net.binis.codegen.validate.length.TestImpl")
@SuppressWarnings("unchecked")
public interface Test {

    // region starters
    static Test.Modify create() {
        return (Test.Modify) EntityCreatorModifier.create(Test.class).with();
    }
    // endregion

    int getValue();
    int getValue2();
    String getValue3();

    Test.Modify with();

    // region inner classes
    interface Fields<T> {
        T value(int value);
        T value2(int value2);
        T value3(String value3);
    }

    interface Modify extends Test.Fields<Test.Modify>, BaseModifier<Test.Modify, Test> {
    }
    // endregion
}

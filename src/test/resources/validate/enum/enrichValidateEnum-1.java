/*Generated code by Binis' code generator.*/
package net.binis.codegen.validateenum;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.creator.EntityCreatorModifier;
import net.binis.codegen.annotation.Default;
import net.binis.codegen.PlainEnum;
import net.binis.codegen.PlainCodeEnum;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.validateenum.TestEnumPrototype", comments = "TestEnumImpl")
@Default("net.binis.codegen.validateenum.TestEnumImpl")
@SuppressWarnings("unchecked")
public interface TestEnum {

    // region starters
    static TestEnum.Modify create() {
        return (TestEnum.Modify) EntityCreatorModifier.create(TestEnum.class).with();
    }
    // endregion

    PlainCodeEnum getCodeEnum();
    PlainEnum getPlain();
    String getStr();
    String getStr2();

    TestEnum.Modify with();

    // region inner classes
    interface Fields<T> {
        T codeEnum(PlainCodeEnum codeEnum);
        T plain(PlainEnum plain);
        T str(String str);
        T str2(String str2);
    }

    interface Modify extends TestEnum.Fields<TestEnum.Modify>, BaseModifier<TestEnum.Modify, TestEnum> {
    }
    // endregion
}

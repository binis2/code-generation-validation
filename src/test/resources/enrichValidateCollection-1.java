/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
public interface Test {
    List<String> getList();
    List<String> getList2();

    void setList(List<String> list);
    void setList2(List<String> list2);

    Test.Modify with();

    interface Modify extends BaseModifier<Test.Modify, Test> {
        CodeList<String, Test.Modify> list();
        Modify list(List<String> list);
        CodeList<String, Test.Modify> list2();
        Modify list2(List<String> list2);
    }
}

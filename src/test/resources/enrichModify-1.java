/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.intf.Prototypable;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.List;

@Generated(value = "net.binis.codegen.TestModifyPrototype", comments = "TestModifyImpl")
public interface TestModify extends Prototypable<SubModify> {
    double getAmount();
    List<Long> getItems();
    Set<SubModify> getSubs();
    String getTitle();

    void setAmount(double amount);
    void setItems(List<Long> items);
    void setSubs(Set<SubModify> subs);
    void setTitle(String title);

    TestModify.Modify with();

    interface Fields<T> {
        T amount(double amount);
        T prototype(SubModify prototype);
        T title(String title);
    }

    interface Modify extends TestModify.Fields<TestModify.Modify>, BaseModifier<TestModify.Modify, TestModify> {
        Modify items(List<Long> items);
        CodeList<Long, TestModify.Modify> items();
        Modify subs(Set<SubModify> subs);
        EmbeddedCodeCollection<SubModify.EmbeddedCollectionModify<TestModify.Modify>, SubModify, TestModify.Modify> subs();
    }
}

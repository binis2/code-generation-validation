/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
public interface Test {
    String getField();
    List<Test> getList();

    void setField(String field);
    void setList(List<Test> list);

    Test.Modify with();

    interface EmbeddedCollectionModify<R> extends Test.EmbeddedModify<Test.EmbeddedCollectionModify<R>, R> {
        EmbeddedCodeCollection<Test.EmbeddedCollectionModify<R>, Test, R> _and();
    }

    interface EmbeddedModify<T, R> extends BaseModifier<T, R>, Test.Fields<T> {
        T list(List<Test> list);
        EmbeddedCodeCollection<Test.EmbeddedCollectionModify<Test.EmbeddedModify<T, R>>, Test, T> list();
    }

    interface Fields<T> {
        T field(String field);
    }

    interface Modify extends EmbeddedModify<Test.Modify, Test> {
    }
}

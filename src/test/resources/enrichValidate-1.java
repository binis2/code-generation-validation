/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeMap;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
public interface Test {
    List<Long> getList();
    Map<Long, String> getMap();
    Set<Long> getSet();
    String getTitle();

    void setList(List<Long> list);
    void setMap(Map<Long, String> map);
    void setSet(Set<Long> set);
    void setTitle(String title);

    Test.Modify with();

    interface Fields<T> {
        T title(String title);
    }

    interface Modify extends Test.Fields<Test.Modify>, BaseModifier<Test.Modify, Test> {
        CodeList<Long, Test.Modify> list();
        Modify list(List<Long> list);
        CodeMap<Long, String, Test.Modify> map();
        Modify map(Map<Long, String> map);

        CodeSet<Long, Test.Modify> set();
        Modify set(Set<Long> set);
    }
}

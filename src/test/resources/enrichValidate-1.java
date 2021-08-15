/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeMap;
import net.binis.codegen.collection.CodeList;
import java.util.Set;
import java.util.Map;
import java.util.List;

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

    interface Modify extends Test.Fields<Test.Modify> {

        Test done();

        Modify list(List<Long> list);

        CodeList<Long, Modify> list();

        Modify map(Map<Long, String> map);

        CodeMap<Long, String, Modify> map();

        Modify set(Set<Long> set);

        CodeSet<Long, Modify> set();
    }
}

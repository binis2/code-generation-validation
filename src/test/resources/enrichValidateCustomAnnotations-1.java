/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeList;
import java.util.Set;
import java.util.List;

public interface Test {

    String getEmail();

    List<Long> getList();

    Set<Long> getSet();

    String getTitle();

    void setEmail(String email);

    void setList(List<Long> list);

    void setSet(Set<Long> set);

    void setTitle(String title);

    Test.Modify with();

    interface Fields<T> {

        T email(String email);

        T title(String title);
    }

    interface Modify extends Test.Fields<Test.Modify> {

        Test done();

        Modify list(List<Long> list);

        CodeList<Long, Modify> list();

        Modify set(Set<Long> set);

        CodeSet<Long, Modify> set();
    }
}

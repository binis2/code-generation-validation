/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.List;

@Generated(value = "TestPrototype", comments = "TestImpl")
public interface Test {

    int getAmount();

    String getEmail();

    String getField();

    String getField1();

    List<Long> getList();

    Set<Long> getSet();

    String getTitle();

    void setAmount(int amount);

    void setEmail(String email);

    void setField(String field);

    void setField1(String field1);

    void setList(List<Long> list);

    void setSet(Set<Long> set);

    void setTitle(String title);

    Test.Modify with();

    interface Fields<T> {

        T amount(int amount);

        T email(String email);

        T field(String field);

        T field1(String field1);

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

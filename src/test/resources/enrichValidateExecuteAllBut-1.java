/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeMap;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.*;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
public interface Test {
    double getAmount();
    int getCounter();
    List<String> getList();
    Map<String, Object> getMap();
    Double getOriginalAmount();
    Set<String> getSet();

    void setAmount(double amount);
    void setCounter(int counter);
    void setList(List<String> list);
    void setMap(Map<String, Object> map);
    void setOriginalAmount(Double originalAmount);
    void setSet(Set<String> set);

    Test.Modify with();

    interface Fields<T> {
        T amount(double amount);
        T counter(int counter);
        T originalAmount(Double originalAmount);
    }

    interface Modify extends Test.Fields<Test.Modify>, BaseModifier<Test.Modify, Test> {
        CodeList<String, Test.Modify> list();
        Modify list(List<String> list);
        CodeMap<String, Object, Test.Modify> map();
        Modify map(Map<String, Object> map);

        CodeSet<String, Test.Modify> set();
        Modify set(Set<String> set);
    }
}

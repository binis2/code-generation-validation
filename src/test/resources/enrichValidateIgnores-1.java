/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.Validatable;
import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeMap;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.annotation.Ignore;
import javax.annotation.processing.Generated;
import java.util.*;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
@Ignore(forValidation = true)
public interface Test extends Validatable {
    @Ignore(forValidation = true)
    List<String> getList();
    Map<String, Object> getMap();
    Set<String> getSet();

    @Ignore(forValidation = true)
    void setList(List<String> list);
    void setMap(Map<String, Object> map);
    void setSet(Set<String> set);

    Test.Modify with();

    interface Modify extends BaseModifier<Test.Modify, Test> {
        CodeList<String, Test.Modify> list();

        @Ignore(forValidation = true)
        Modify list(List<String> list);
        CodeMap<String, Object, Test.Modify> map();
        Modify map(Map<String, Object> map);

        CodeSet<String, Test.Modify> set();
        Modify set(Set<String> set);
    }
}

/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.MixInPrototype", comments = "MixInImpl")
public interface MixIn extends Test {
    MixIn.Modify asMixIn();

    List<Long> getList();

    void setList(List<Long> list);

    interface Modify extends BaseModifier<MixIn.Modify, MixIn> {
        Modify list(List<Long> list);
        CodeList<Long, MixIn.Modify> list();
    }
}

/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.intf.Prototypable;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;

@Generated(value = "SubModifyPrototype", comments = "SubModifyImpl")
public interface SubModify extends Prototypable<SubModify> {

    double getSubAmount();

    String getSubtitle();

    void setSubAmount(double subAmount);

    void setSubtitle(String subtitle);

    SubModify.Modify with();

    interface EmbeddedModify<T> extends SubModify.Fields<SubModify.EmbeddedModify<T>> {

        EmbeddedCodeCollection<EmbeddedModify<T>, SubModify, T> and();
    }

    interface Fields<T> {

        T prototype(SubModify prototype);

        T subAmount(double subAmount);

        T subtitle(String subtitle);
    }

    interface Modify extends SubModify.Fields<SubModify.Modify> {

        SubModify done();
    }
}

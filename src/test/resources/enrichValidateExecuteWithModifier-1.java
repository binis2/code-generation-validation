/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.BaseModifier;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
public interface Test {
    double getAmount();
    Double getOriginalAmount();

    void setAmount(double amount);
    void setOriginalAmount(Double originalAmount);

    Test.Modify with();

    interface Fields<T> {
        T amount(double amount);
        T originalAmount(Double originalAmount);
    }

    interface Modify extends Test.Fields<Test.Modify>, BaseModifier<Test.Modify, Test> {
    }
}

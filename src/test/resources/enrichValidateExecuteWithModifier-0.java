/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.executor.LambdaExecutor;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected double amount;

    protected Double originalAmount;

    public TestImpl() {
    }

    public double getAmount() {
        return amount;
    }

    public Double getOriginalAmount() {
        return originalAmount;
    }

    public void setAmount(double amount) {
        Validation.start(this.getClass(), "amount", amount).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Double>) value -> {
            if (this.originalAmount == null) {
                this.originalAmount = value;
            }
        })).perform(v -> this.amount = v);
    }

    public void setOriginalAmount(Double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test.Modify amount(double amount) {
            Validation.start(this.getClass(), "amount", amount).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Double>) value -> {
                if (TestImpl.this.originalAmount == null) {
                    TestImpl.this.originalAmount = value;
                }
            })).perform(v -> TestImpl.this.amount = v);
            return this;
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify originalAmount(Double originalAmount) {
            TestImpl.this.originalAmount = originalAmount;
            return this;
        }
    }
}

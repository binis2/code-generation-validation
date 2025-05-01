/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.executor.LambdaExecutor;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.CodeSetImpl;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeMapImpl;
import net.binis.codegen.collection.CodeMap;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.*;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected double amount;

    protected int counter;

    protected List<String> list;

    protected Map<String, Object> map;

    protected Double originalAmount;

    protected Set<String> set;

    public TestImpl() {
    }

    public double getAmount() {
        return amount;
    }

    public int getCounter() {
        return counter;
    }

    public List<String> getList() {
        return list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Double getOriginalAmount() {
        return originalAmount;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setAmount(double amount) {
        Validation.start(this.getClass(), "amount", amount).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Double>) v -> this.counter++)).perform(v -> this.amount = v);
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setList(List<String> list) {
        Validation.start(this.getClass(), "list", list).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<List<String>>) v -> this.counter++)).validateCollection(NullValidator.class, "({field}) Value can't be null").perform(v -> this.list = v);
    }

    public void setMap(Map<String, Object> map) {
        Validation.start(this.getClass(), "map", map).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Map<String, Object>>) v -> this.counter++)).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> this.map = v);
    }

    public void setOriginalAmount(Double originalAmount) {
        Validation.start(this.getClass(), "originalAmount", originalAmount).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Double>) v -> this.counter++)).perform(v -> this.originalAmount = v);
    }

    public void setSet(Set<String> set) {
        Validation.start(this.getClass(), "set", set).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Set<String>>) v -> this.counter++)).sanitizeCollection(TrimSanitizer.class).perform(v -> this.set = v);
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
            Validation.start(this.getClass(), "amount", amount).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Double>) v -> TestImpl.this.counter++)).perform(v -> TestImpl.this.amount = v);
            return this;
        }

        public Test.Modify counter(int counter) {
            TestImpl.this.counter = counter;
            return this;
        }

        public Test done() {
            return TestImpl.this;
        }

        public CodeList list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list, value -> Validation.start(this.getClass(), "list[value]", value).validate(NullValidator.class, "({field}) Value can't be null"));
        }

        public Test.Modify list(List<String> list) {
            Validation.start(this.getClass(), "list", list).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<List<String>>) v -> TestImpl.this.counter++)).validateCollection(NullValidator.class, "({field}) Value can't be null").perform(v -> TestImpl.this.list = v);
            return this;
        }

        public CodeMap map() {
            if (TestImpl.this.map == null) {
                TestImpl.this.map = new java.util.HashMap<>();
            }
            return new CodeMapImpl<>(this, TestImpl.this.map);
        }

        public Test.Modify map(Map<String, Object> map) {
            Validation.start(this.getClass(), "map", map).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Map<String, Object>>) v -> TestImpl.this.counter++)).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> TestImpl.this.map = v);
            return this;
        }

        public Test.Modify originalAmount(Double originalAmount) {
            Validation.start(this.getClass(), "originalAmount", originalAmount).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Double>) v -> TestImpl.this.counter++)).perform(v -> TestImpl.this.originalAmount = v);
            return this;
        }

        public CodeSet set() {
            if (TestImpl.this.set == null) {
                TestImpl.this.set = new java.util.HashSet<>();
            }
            return new CodeSetImpl<>(this, TestImpl.this.set, value -> Validation.start(this.getClass(), "set[value]", value).sanitize(TrimSanitizer.class));
        }

        public Test.Modify set(Set<String> set) {
            Validation.start(this.getClass(), "set", set).execute(LambdaExecutor.class, "({field}) Invalid value!", ((java.util.function.Consumer<Set<String>>) v -> TestImpl.this.counter++)).sanitizeCollection(TrimSanitizer.class).perform(v -> TestImpl.this.set = v);
            return this;
        }
    }
}

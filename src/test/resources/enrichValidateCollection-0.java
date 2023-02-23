/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.validator.LambdaValidator;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected List<String> list;

    protected List<String> list2;

    public TestImpl() {
    }

    public List<String> getList() {
        return list;
    }

    public List<String> getList2() {
        return list2;
    }

    public void setList(List<String> list) {
        Validation.start(this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(LambdaValidator.class, "({field}) Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank)).perform(v -> this.list = v);
    }

    public void setList2(List<String> list2) {
        Validation.start(this.getClass(), "list2", list2).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").validateCollection(LambdaValidator.class, "({field}) Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank)).perform(v -> this.list2 = v);
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify list(List<String> list) {
            Validation.start(this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(LambdaValidator.class, "({field}) Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank)).perform(v -> TestImpl.this.list = v);
            return this;
        }

        public CodeList list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list, value -> Validation.start(this.getClass(), "list", value).validate(LambdaValidator.class, "({field}) Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank)));
        }

        public Test.Modify list2(List<String> list2) {
            Validation.start(this.getClass(), "list2", list2).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").validateCollection(LambdaValidator.class, "({field}) Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank)).perform(v -> TestImpl.this.list2 = v);
            return this;
        }

        public CodeList list2() {
            if (TestImpl.this.list2 == null) {
                TestImpl.this.list2 = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list2, value -> Validation.start(this.getClass(), "list2", value).validate(NullValidator.class, "({field}) Value can't be null").validate(LambdaValidator.class, "({field}) Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank)));
        }
    }
}

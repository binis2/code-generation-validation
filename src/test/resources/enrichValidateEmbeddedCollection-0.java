/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.EmbeddedCodeListImpl;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected String field;

    protected List<Test> list;

    public TestImpl() {
    }

    public String getField() {
        return field;
    }

    public List<Test> getList() {
        return list;
    }

    public void setField(String field) {
        Validation.start(this.getClass(), "field", field).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> this.field = v);
    }

    public void setList(List<Test> list) {
        Validation.start(this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").perform(v -> this.list = v);
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TestImplCollectionModifyImpl extends TestImplEmbeddedModifyImpl implements Test.EmbeddedCollectionModify {

        protected TestImplCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class TestImplEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements Test.EmbeddedModify<T, R> {

        protected TestImplEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T field(String field) {
            Validation.start(this.getClass(), "field", field).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> TestImpl.this.field = v);
            return (T) this;
        }

        public EmbeddedCodeCollection list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new EmbeddedCodeListImpl<>(this, TestImpl.this.list, Test.class, value -> Validation.start(this.getClass(), "list[value]", value).validate(NullValidator.class, "({field}) Value can't be null"));
        }

        public T list(List<Test> list) {
            Validation.start(this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").perform(v -> TestImpl.this.list = v);
            return (T) this;
        }
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends TestImplEmbeddedModifyImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }
    }
}

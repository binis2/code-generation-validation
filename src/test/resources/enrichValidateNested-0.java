/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.Validatable;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected List<Test.Item> list;

    // region constructor & initializer
    {
        CodeFactory.registerType(Test.class, TestImpl::new, null);
    }

    public TestImpl() {
    }
    // endregion

    // region getters
    public List<Test.Item> getList() {
        return list;
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }
    // endregion

    // region inner classes
    @SuppressWarnings("unchecked")
    public static class ItemImpl implements Item, Validatable {

        protected String value;

        // region constructor & initializer
        {
            CodeFactory.registerType(Test.Item.class, ItemImpl::new, null);
        }

        public ItemImpl() {
        }
        // endregion

        // region getters
        public String getValue() {
            return value;
        }

        public void validate() {
            Validation.form(this.getClass(), e -> Validation.start(e, this.getClass(), "value", value).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> value = v));
        }
        // endregion
    }

    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify list(List<Test.Item> list) {
            TestImpl.this.list = list;
            return this;
        }
    }
    // endregion
}

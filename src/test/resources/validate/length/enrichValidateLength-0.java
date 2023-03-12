/*Generated code by Binis' code generator.*/
package net.binis.codegen.validate.length;

import net.binis.codegen.validation.validator.LengthValidator;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.validate.length.TestPrototype", comments = "Test")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected int value;

    protected int value2;

    // region constructor & initializer
    {
        CodeFactory.registerType(Test.class, TestImpl::new, null);
    }

    public TestImpl() {
    }
    // endregion

    // region getters
    public int getValue() {
        return value;
    }

    public int getValue2() {
        return value2;
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }
    // endregion

    // region inner classes
    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify value(int value) {
            Validation.start(this.getClass(), "value", value).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, 3, 4).perform(v -> TestImpl.this.value = v);
            return this;
        }

        public Test.Modify value2(int value2) {
            Validation.start(this.getClass(), "value2", value2).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, 3, 4).perform(v -> TestImpl.this.value2 = v);
            return this;
        }
    }
    // endregion
}

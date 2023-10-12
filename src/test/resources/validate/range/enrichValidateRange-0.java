/*Generated code by Binis' code generator.*/
package net.binis.codegen.validate.range;

import net.binis.codegen.validation.validator.RangeValidator;
import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.validator.LengthValidator;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.Validatable;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "net.binis.codegen.validate.range.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Modifiable<Test.Modify>, Validatable {

    protected List<Integer> list;

    protected int value;

    // region constructor & initializer
    {
        CodeFactory.registerType(Test.class, TestImpl::new, null);
    }

    public TestImpl() {
    }
    // endregion

    // region getters
    public List<Integer> getList() {
        return list;
    }

    public int getValue() {
        return value;
    }

    public void validate() {
        Validation.form(this.getClass(), e -> Validation.start(e, this.getClass(), "value", value).validate(NullValidator.class, "({field}) Value can't be null").validateWithMessages(RangeValidator.class, new String[] { "min %2$d(%3$d)", "max %2$d(%4$d)" }, 0, 1000).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, 1, 255).perform(v -> value = v), e -> Validation.start(e, this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").validateWithMessagesCollection(RangeValidator.class, new String[] { "minC %2$d(%3$d)", "maxC %2$d(%4$d)" }, 0, 1000).validateWithMessagesCollection(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, 1, 255).perform(v -> list = v));
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }
    // endregion

    // region inner classes
    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify list(List<Integer> list) {
            Validation.start(this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").validateWithMessagesCollection(RangeValidator.class, new String[] { "minC %2$d(%3$d)", "maxC %2$d(%4$d)" }, 0, 1000).validateWithMessagesCollection(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, 1, 255).perform(v -> TestImpl.this.list = v);
            return this;
        }

        public CodeList list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list, value -> Validation.start(this.getClass(), "list", value).validate(NullValidator.class, "({field}) Value can't be null").validateWithMessages(RangeValidator.class, new String[] { "minC %2$d(%3$d)", "maxC %2$d(%4$d)" }, 0, 1000).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, 1, 255));
        }

        public Test.Modify value(int value) {
            Validation.start(this.getClass(), "value", value).validate(NullValidator.class, "({field}) Value can't be null").validateWithMessages(RangeValidator.class, new String[] { "min %2$d(%3$d)", "max %2$d(%4$d)" }, 0, 1000).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, 1, 255).perform(v -> TestImpl.this.value = v);
            return this;
        }
    }
    // endregion
}

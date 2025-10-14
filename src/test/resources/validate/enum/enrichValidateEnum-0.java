/*Generated code by Binis' code generator.*/
package net.binis.codegen.validateenum;

import net.binis.codegen.validation.validator.EnumValidator;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.PlainEnum;
import net.binis.codegen.PlainCodeEnum;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.validateenum.TestEnumPrototype", comments = "TestEnum")
public class TestEnumImpl implements TestEnum, Modifiable<TestEnum.Modify> {

    protected PlainCodeEnum codeEnum;

    protected PlainEnum plain;

    protected String str;

    protected String str2;

    // region constructor & initializer
    static {
        CodeFactory.registerType(TestEnum.class, TestEnumImpl::new, null);
    }

    public TestEnumImpl() {
    }
    // endregion

    // region getters
    public PlainCodeEnum getCodeEnum() {
        return codeEnum;
    }

    public PlainEnum getPlain() {
        return plain;
    }

    public String getStr() {
        return str;
    }

    public String getStr2() {
        return str2;
    }

    public TestEnum.Modify with() {
        return new TestEnumModifyImpl(this);
    }
    // endregion

    // region inner classes
    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TestEnumModifyImpl extends BaseModifierImpl<TestEnum.Modify, TestEnum> implements TestEnum.Modify {

        protected TestEnumModifyImpl(TestEnum parent) {
            super(parent);
        }

        public TestEnum.Modify codeEnum(PlainCodeEnum codeEnum) {
            Validation.start(this.getClass(), "codeEnum", codeEnum).validate(EnumValidator.class, "({field}) Invalid enum value ({value})!", void.class).perform(v -> TestEnumImpl.this.codeEnum = v);
            return this;
        }

        public TestEnum done() {
            return TestEnumImpl.this;
        }

        public TestEnum.Modify plain(PlainEnum plain) {
            Validation.start(this.getClass(), "plain", plain).validate(EnumValidator.class, "({field}) Invalid enum value ({value})!", void.class).perform(v -> TestEnumImpl.this.plain = v);
            return this;
        }

        public TestEnum.Modify str(String str) {
            Validation.start(this.getClass(), "str", str).validate(EnumValidator.class, "({field}) Invalid enum value ({value})!", PlainEnum.class).perform(v -> TestEnumImpl.this.str = v);
            return this;
        }

        public TestEnum.Modify str2(String str2) {
            Validation.start(this.getClass(), "str2", str2).validate(EnumValidator.class, "({field}) Invalid enum value ({value})!", PlainCodeEnum.class).perform(v -> TestEnumImpl.this.str2 = v);
            return this;
        }
    }
    // endregion
}

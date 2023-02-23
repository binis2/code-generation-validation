/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, MixIn, Modifiable<Test.Modify> {

    protected List<Long> list;

    protected String title;

    public TestImpl() {
    }

    public MixIn.Modify asMixIn() {
        return new MixInModifyImpl(this);
    }

    public List<Long> getList() {
        return list;
    }

    public String getTitle() {
        return title;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public void setTitle(String title) {
        Validation.start(this.getClass(), "title", title).sanitize(TrimSanitizer.class).perform(v -> this.title = v);
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    @SuppressWarnings("unchecked")
    protected class MixInModifyImpl extends BaseModifierImpl<MixIn.Modify, MixIn> implements MixIn.Modify {

        protected MixInModifyImpl(MixIn parent) {
            super(parent);
        }

        public MixIn done() {
            return TestImpl.this;
        }

        public MixIn.Modify list(List<Long> list) {
            Validation.start(this.getClass(), "list", list).validate(NullValidator.class, null).perform(v -> TestImpl.this.list = v);
            return this;
        }

        public CodeList list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list);
        }

        public MixIn.Modify title(String title) {
            Validation.start(this.getClass(), "title", title).sanitize(TrimSanitizer.class).perform(v -> TestImpl.this.title = v);
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify title(String title) {
            Validation.start(this.getClass(), "title", title).sanitize(TrimSanitizer.class).perform(v -> TestImpl.this.title = v);
            return this;
        }
    }
}

/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.sanitizer.OnlyNotNullsLambdaSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import javax.annotation.processing.Generated;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected String title;

    public TestImpl() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Validation.start(this.getClass(), "title", title).sanitize(TrimSanitizer.class).sanitize(OnlyNotNullsLambdaSanitizer.class, ((java.util.function.Function<String, String>) String::toUpperCase)).perform(v -> this.title = v);
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify title(String title) {
            Validation.start(this.getClass(), "title", title).sanitize(TrimSanitizer.class).sanitize(OnlyNotNullsLambdaSanitizer.class, ((java.util.function.Function<String, String>) String::toUpperCase)).perform(v -> TestImpl.this.title = v);
            return this;
        }
    }
}

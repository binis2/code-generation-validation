/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.RegExValidator;
import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.validator.LengthValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.Validatable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.Test.Sub;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Validatable {

    protected List<Long> list;

    protected Map<Long, String> map;

    protected Set<Long> set;

    protected Test.Sub sub;

    protected String title = "asd";

    // region constructor & initializer
    static {
        CodeFactory.registerType(Test.class, TestImpl::new, null);
    }

    public TestImpl() {
    }
    // endregion

    // region getters
    public List<Long> getList() {
        return list;
    }

    public Map<Long, String> getMap() {
        return map;
    }

    public Set<Long> getSet() {
        return set;
    }

    public Test.Sub getSub() {
        return sub;
    }

    public String getTitle() {
        return title;
    }

    public void validate() {
        Validation.form(this.getClass(), e -> Validation.start(e, this.getClass(), "title", title).validateWithMessages(LengthValidator.class, new String[] { "Must be longer than %4$d!", "Must be shorter than %3$d!" }, 10, 255).sanitize(TrimSanitizer.class).validate(RegExValidator.class, "({field}) Invalid Email!", "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$").perform(v -> title = v), e -> Validation.start(e, this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> list = v), e -> Validation.start(e, this.getClass(), "set", set).validate(NullValidator.class, "test", "asd", "fgh").perform(v -> set = v), e -> Validation.start(e, this.getClass(), "map", map).validate(NullValidator.class, "another test").perform(v -> map = v), e -> Validation.start(e, this.getClass(), "sub", sub).child());
    }
    // endregion

    // region inner classes
    @SuppressWarnings("unchecked")
    public static class SubImpl implements Sub, Validatable {

        protected String value;

        // region constructor & initializer
        static {
            CodeFactory.registerType(Test.Sub.class, SubImpl::new, null);
        }

        public SubImpl() {
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
    // endregion
}

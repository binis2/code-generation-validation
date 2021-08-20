/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.RegExValidator;
import net.binis.codegen.validation.validator.RangeValidator;
import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.validator.LambdaValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.sanitizer.ReplaceSanitizer;
import net.binis.codegen.validation.sanitizer.LambdaSanitizer;
import net.binis.codegen.modifier.Modifiable;
import static net.binis.codegen.factory.CodeFactory.validate;
import static net.binis.codegen.factory.CodeFactory.sanitize;
import net.binis.codegen.collection.CodeSetImpl;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import lombok.Data;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
@Data
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected int amount;

    protected String email;

    protected String field;

    protected List<Long> list;

    protected Set<Long> set;

    protected String title;

    public TestImpl() {
    }

    public int getAmount() {
        return amount;
    }

    public String getEmail() {
        return email;
    }

    public String getField() {
        return field;
    }

    public List<Long> getList() {
        return list;
    }

    public Set<Long> getSet() {
        return set;
    }

    public String getTitle() {
        return title;
    }

    public void setAmount(int amount) {
        validate(amount, RangeValidator.class, "%f is not in range [%f, %f]", 0, 10);
        this.amount = amount;
    }

    public void setEmail(String email) {
        email = sanitize(email, ReplaceSanitizer.class, "\\s+", "_");
        validate(email, RegExValidator.class, "Invalid Email!", "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        this.email = email;
    }

    public void setField(String field) {
        validate(field, LambdaValidator.class, "Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank));
        field = sanitize(field, LambdaSanitizer.class, ((java.util.function.Function<String, String>) String::toLowerCase));
        field = sanitize(field, LambdaSanitizer.class, ((java.util.function.Function<String, String>) String::toUpperCase));
        this.field = field;
    }

    public void setList(List<Long> list) {
        validate(list, NullValidator.class, "Value can't be null");
        this.list = list;
    }

    public void setSet(Set<Long> set) {
        validate(set, RegExValidator.class, "Test", "^$");
        this.set = set;
    }

    public void setTitle(String title) {
        title = sanitize(title, ReplaceSanitizer.class, "\\s+", "");
        title = sanitize(title, TrimSanitizer.class);
        this.title = title;
    }

    public Test.Modify with() {
        return new TestModifyImpl();
    }

    protected class TestModifyImpl implements Test.Modify {

        public Test.Modify amount(int amount) {
            validate(amount, RangeValidator.class, "%f is not in range [%f, %f]", 0, 10);
            TestImpl.this.amount = amount;
            return this;
        }

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify email(String email) {
            email = sanitize(email, ReplaceSanitizer.class, "\\s+", "_");
            validate(email, RegExValidator.class, "Invalid Email!", "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
            TestImpl.this.email = email;
            return this;
        }

        public Test.Modify field(String field) {
            validate(field, LambdaValidator.class, "Value can't be blank!", ((java.util.function.Predicate<String>) org.apache.commons.lang3.StringUtils::isNotBlank));
            field = sanitize(field, LambdaSanitizer.class, ((java.util.function.Function<String, String>) String::toLowerCase));
            field = sanitize(field, LambdaSanitizer.class, ((java.util.function.Function<String, String>) String::toUpperCase));
            TestImpl.this.field = field;
            return this;
        }

        public Test.Modify list(List<Long> list) {
            validate(list, NullValidator.class, "Value can't be null");
            TestImpl.this.list = list;
            return this;
        }

        public CodeList<Long, Test.Modify> list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list);
        }

        public Test.Modify set(Set<Long> set) {
            validate(set, RegExValidator.class, "Test", "^$");
            TestImpl.this.set = set;
            return this;
        }

        public CodeSet<Long, Test.Modify> set() {
            if (TestImpl.this.set == null) {
                TestImpl.this.set = new java.util.HashSet<>();
            }
            return new CodeSetImpl<>(this, TestImpl.this.set);
        }

        public Test.Modify title(String title) {
            title = sanitize(title, ReplaceSanitizer.class, "\\s+", "");
            title = sanitize(title, TrimSanitizer.class);
            TestImpl.this.title = title;
            return this;
        }
    }
}

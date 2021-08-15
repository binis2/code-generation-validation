/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.RegExValidator;
import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.sanitizer.ReplaceSanitizer;
import net.binis.codegen.modifier.Modifiable;
import static net.binis.codegen.factory.CodeFactory.validate;
import static net.binis.codegen.factory.CodeFactory.sanitize;
import net.binis.codegen.collection.CodeSetImpl;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import lombok.Data;
import java.util.Set;
import java.util.List;

@Data
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected String email;

    protected List<Long> list;

    protected Set<Long> set;

    protected String title;

    public TestImpl() {
    }

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        email = sanitize(email, ReplaceSanitizer.class, "\\s+", "_");
        validate(email, RegExValidator.class, null, "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        this.email = email;
    }

    public void setList(List<Long> list) {
        validate(list, NullValidator.class, null);
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

        public Test done() {
            return TestImpl.this;
        }

        public Test.Modify email(String email) {
            email = sanitize(email, ReplaceSanitizer.class, "\\s+", "_");
            validate(email, RegExValidator.class, null, "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
            TestImpl.this.email = email;
            return this;
        }

        public Test.Modify list(List<Long> list) {
            validate(list, NullValidator.class, null);
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

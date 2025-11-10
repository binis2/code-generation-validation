/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.CodeSetImpl;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeMapImpl;
import net.binis.codegen.collection.CodeMap;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import net.binis.codegen.annotation.Ignore;
import javax.annotation.processing.Generated;
import java.util.*;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@Ignore(forValidation = true)
@SuppressWarnings("unchecked")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    @Ignore(forValidation = true)
    protected List<String> list;

    protected Map<String, Object> map;

    protected Set<String> set;

    public TestImpl() {
    }

    @Ignore(forValidation = true)
    public List<String> getList() {
        return list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Set<String> getSet() {
        return set;
    }

    @Ignore(forValidation = true)
    public void setList(List<String> list) {
        Validation.start(this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").perform(v -> this.list = v);
    }

    public void setMap(Map<String, Object> map) {
        Validation.start(this.getClass(), "map", map).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> this.map = v);
    }

    public void setSet(Set<String> set) {
        Validation.start(this.getClass(), "set", set).sanitizeCollection(TrimSanitizer.class).perform(v -> this.set = v);
    }

    public void validate() {
        Validation.form(this.getClass(), e -> Validation.start(e, this.getClass(), "map", map).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> map = v), e -> Validation.start(e, this.getClass(), "set", set).sanitizeCollection(TrimSanitizer.class).perform(v -> set = v));
    }

    public Test.Modify with() {
        return new TestModifyImpl(this);
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class TestModifyImpl extends BaseModifierImpl<Test.Modify, Test> implements Test.Modify {

        protected TestModifyImpl(Test parent) {
            super(parent);
        }

        public Test done() {
            return TestImpl.this;
        }

        public CodeList list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list, value -> Validation.start(this.getClass(), "list[value]", value).validate(NullValidator.class, "({field}) Value can't be null"));
        }

        public Test.Modify list(List<String> list) {
            Validation.start(this.getClass(), "list", list).validate(NullValidator.class, "({field}) Value can't be null").validateCollection(NullValidator.class, "({field}) Value can't be null").perform(v -> TestImpl.this.list = v);
            return this;
        }

        public CodeMap map() {
            if (TestImpl.this.map == null) {
                TestImpl.this.map = new java.util.HashMap<>();
            }
            return new CodeMapImpl<>(this, TestImpl.this.map);
        }

        public Test.Modify map(Map<String, Object> map) {
            Validation.start(this.getClass(), "map", map).validate(NullValidator.class, "({field}) Value can't be null").perform(v -> TestImpl.this.map = v);
            return this;
        }

        public CodeSet set() {
            if (TestImpl.this.set == null) {
                TestImpl.this.set = new java.util.HashSet<>();
            }
            return new CodeSetImpl<>(this, TestImpl.this.set, value -> Validation.start(this.getClass(), "set[value]", value).sanitize(TrimSanitizer.class));
        }

        public Test.Modify set(Set<String> set) {
            Validation.start(this.getClass(), "set", set).sanitizeCollection(TrimSanitizer.class).perform(v -> TestImpl.this.set = v);
            return this;
        }
    }
}

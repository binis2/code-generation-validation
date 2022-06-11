/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.validator.LengthValidator;
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
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl implements Test, Modifiable<Test.Modify> {

    protected List<Long> list;

    protected Map<Long, String> map;

    protected Set<Long> set;

    protected String title;

    public TestImpl() {
    }

    public List<Long> getList() {
        return list;
    }

    public Map<Long, String> getMap() {
        return map;
    }

    public Set<Long> getSet() {
        return set;
    }

    public String getTitle() {
        return title;
    }

    public void setList(List<Long> list) {
        Validation.start("list", list).validate(NullValidator.class, null).perform(v -> this.list = v);
    }

    public void setMap(Map<Long, String> map) {
        Validation.start("map", map).validate(NullValidator.class, "test").perform(v -> this.map = v);
    }

    public void setSet(Set<Long> set) {
        Validation.start("set", set).validate(NullValidator.class, "test", "asd", "fgh").perform(v -> this.set = v);
    }

    public void setTitle(String title) {
        Validation.start("title", title).validateWithMessages(LengthValidator.class, new String[] { "Must be longer than %4$d!", "Must be shorter than %3$d!" }, 255, 10).sanitize(TrimSanitizer.class).perform(v -> this.title = v);
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

        public Test.Modify list(List<Long> list) {
            Validation.start("list", list).validate(NullValidator.class, null).perform(v -> TestImpl.this.list = v);
            return this;
        }

        public CodeList list() {
            if (TestImpl.this.list == null) {
                TestImpl.this.list = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestImpl.this.list);
        }

        public Test.Modify map(Map<Long, String> map) {
            Validation.start("map", map).validate(NullValidator.class, "test").perform(v -> TestImpl.this.map = v);
            return this;
        }

        public CodeMap map() {
            if (TestImpl.this.map == null) {
                TestImpl.this.map = new java.util.HashMap<>();
            }
            return new CodeMapImpl<>(this, TestImpl.this.map);
        }

        public Test.Modify set(Set<Long> set) {
            Validation.start("set", set).validate(NullValidator.class, "test", "asd", "fgh").perform(v -> TestImpl.this.set = v);
            return this;
        }

        public CodeSet set() {
            if (TestImpl.this.set == null) {
                TestImpl.this.set = new java.util.HashSet<>();
            }
            return new CodeSetImpl<>(this, TestImpl.this.set);
        }

        public Test.Modify title(String title) {
            Validation.start("title", title).validateWithMessages(LengthValidator.class, new String[] { "Must be longer than %4$d!", "Must be shorter than %3$d!" }, 255, 10).sanitize(TrimSanitizer.class).perform(v -> TestImpl.this.title = v);
            return this;
        }
    }
}

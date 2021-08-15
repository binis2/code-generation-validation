/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.modifier.Modifiable;
import static net.binis.codegen.factory.CodeFactory.validate;
import static net.binis.codegen.factory.CodeFactory.sanitize;
import net.binis.codegen.collection.CodeSetImpl;
import net.binis.codegen.collection.CodeSet;
import net.binis.codegen.collection.CodeMapImpl;
import net.binis.codegen.collection.CodeMap;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import java.util.Set;
import java.util.Map;
import java.util.List;

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
        validate(list, NullValidator.class, null);
        this.list = list;
    }

    public void setMap(Map<Long, String> map) {
        validate(map, NullValidator.class, "test");
        this.map = map;
    }

    public void setSet(Set<Long> set) {
        validate(set, NullValidator.class, "test", "asd", "fgh");
        this.set = set;
    }

    public void setTitle(String title) {
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

        public Test.Modify map(Map<Long, String> map) {
            validate(map, NullValidator.class, "test");
            TestImpl.this.map = map;
            return this;
        }

        public CodeMap<Long, String, Test.Modify> map() {
            if (TestImpl.this.map == null) {
                TestImpl.this.map = new java.util.HashMap<>();
            }
            return new CodeMapImpl<>(this, TestImpl.this.map);
        }

        public Test.Modify set(Set<Long> set) {
            validate(set, NullValidator.class, "test", "asd", "fgh");
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
            title = sanitize(title, TrimSanitizer.class);
            TestImpl.this.title = title;
            return this;
        }
    }
}

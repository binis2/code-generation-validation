/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.NullValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.Map;
import java.util.List;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl implements Test {

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

    public TestImpl list(List<Long> list) {
        this.list = list;
        return this;
    }

    public TestImpl map(Map<Long, String> map) {
        this.map = map;
        return this;
    }

    public TestImpl set(Set<Long> set) {
        this.set = set;
        return this;
    }

    public TestImpl title(String title) {
        Validation.start(this.getClass(), "title", title).validate(NullValidator.class, "(%s) Value can't be null").sanitize(TrimSanitizer.class).perform(v -> this.title = v);
        return this;
    }
}

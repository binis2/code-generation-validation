/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.LengthValidator;
import net.binis.codegen.validation.flow.Validation;
import javax.annotation.processing.Generated;

@Generated(value = "TestPrototype", comments = "Test")
public class TestImpl implements Test {

    protected String field;

    protected String field1;

    public TestImpl() {
    }

    public String getField() {
        return field;
    }

    public String getField1() {
        return field1;
    }

    public void setField(String field) {
        Validation.start(this.getClass(), "field", field).validateWithMessages(LengthValidator.class, new String[] { "Value for field '%s' is shorter than %3$d!", "Value for field '%s' is longer than %4$d!" }, -1, 3).perform(v -> this.field = v);
    }

    public void setField1(String field1) {
        Validation.start(this.getClass(), "field1", field1).validateWithMessages(LengthValidator.class, new String[] { "Value for field '%s' is shorter than %3$d!", "Value for field '%s' is longer than %4$d!" }, -1, 3).perform(v -> this.field1 = v);
    }
}

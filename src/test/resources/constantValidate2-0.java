/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.LengthValidator;
import net.binis.codegen.validation.sanitizer.LengthSanitizer;
import net.binis.codegen.validation.flow.Validation;
import static net.binis.codegen.constants.Constants.STATIC_MAX_LENGTH;
import net.binis.codegen.constants.Constants;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test {

    protected String calculated;

    protected String calculated2;

    public TestImpl() {
    }

    public String getCalculated() {
        return calculated;
    }

    public String getCalculated2() {
        return calculated2;
    }

    public void setCalculated(String calculated) {
        Validation.start(this.getClass(), "calculated", calculated).validateWithMessages(LengthValidator.class, new String[] { Constants.STATIC_TEXT + "!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, -1, Constants.STATIC_MAX_LENGTH * STATIC_MAX_LENGTH).perform(v -> this.calculated = v);
    }

    public void setCalculated2(String calculated2) {
        Validation.start(this.getClass(), "calculated2", calculated2).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, -1, 10 * Constants.STATIC_MAX_LENGTH).sanitize(LengthSanitizer.class, 10 * STATIC_MAX_LENGTH).perform(v -> this.calculated2 = v);
    }
}

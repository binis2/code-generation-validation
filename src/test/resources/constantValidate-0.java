/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.LengthValidator;
import net.binis.codegen.validation.flow.Validation;
import static net.binis.codegen.constants.Constants.STATIC_MAX_LENGTH;
import net.binis.codegen.constants.Constants;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "Test")
@SuppressWarnings("unchecked")
public class TestImpl implements Test {

    static final public int MAX_LENGTH = 100;

    protected String calculated;

    protected String compiledSubtitle;

    protected String compiledTitle;

    protected String other;

    protected String subtitle;

    protected String title;

    public TestImpl() {
    }

    public String getCalculated() {
        return calculated;
    }

    public String getCompiledSubtitle() {
        return compiledSubtitle;
    }

    public String getCompiledTitle() {
        return compiledTitle;
    }

    public String getOther() {
        return other;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setCalculated(String calculated) {
        Validation.start(this.getClass(), "calculated", calculated).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", Constants.STATIC_TEXT + "!" }, -1, 10 * 10).perform(v -> this.calculated = v);
    }

    public void setCompiledSubtitle(String compiledSubtitle) {
        Validation.start(this.getClass(), "compiledSubtitle", compiledSubtitle).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, -1, Constants.STATIC_MAX_LENGTH).perform(v -> this.compiledSubtitle = v);
    }

    public void setCompiledTitle(String compiledTitle) {
        Validation.start(this.getClass(), "compiledTitle", compiledTitle).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, -1, STATIC_MAX_LENGTH).perform(v -> this.compiledTitle = v);
    }

    public void setOther(String other) {
        Validation.start(this.getClass(), "other", other).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, -1, Test.LENGTH).perform(v -> this.other = v);
    }

    public void setSubtitle(String subtitle) {
        Validation.start(this.getClass(), "subtitle", subtitle).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, -1, TestImpl.MAX_LENGTH).perform(v -> this.subtitle = v);
    }

    public void setTitle(String title) {
        Validation.start(this.getClass(), "title", title).validateWithMessages(LengthValidator.class, new String[] { "Value ({value}) for field '{field}' is shorter than {param[0]}!", "Value ({value}) for field '{field}' is longer than {param[1]}!" }, -1, MAX_LENGTH).perform(v -> this.title = v);
    }
}

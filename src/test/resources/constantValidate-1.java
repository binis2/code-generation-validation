/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.TestPrototype", comments = "TestImpl")
public interface Test {

    static final int LENGTH = 1000;

    String getCalculated();
    String getCompiledSubtitle();
    String getCompiledTitle();
    String getOther();
    String getSubtitle();
    String getTitle();

    void setCalculated(String calculated);
    void setCompiledSubtitle(String compiledSubtitle);
    void setCompiledTitle(String compiledTitle);
    void setOther(String other);
    void setSubtitle(String subtitle);
    void setTitle(String title);
}

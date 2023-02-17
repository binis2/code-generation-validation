/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.collection.EmbeddedCodeSetImpl;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import net.binis.codegen.collection.CodeListImpl;
import net.binis.codegen.collection.CodeList;
import javax.annotation.processing.Generated;
import java.util.Set;
import java.util.List;

@Generated(value = "TestModifyPrototype", comments = "TestModify")
public class TestModifyImpl implements TestModify, Modifiable<TestModify.Modify> {

    protected double amount;

    protected List<Long> items;

    protected SubModify prototype;

    protected Set<SubModify> subs;

    protected String title;

    public TestModifyImpl() {
    }

    public double getAmount() {
        return amount;
    }

    public List<Long> getItems() {
        return items;
    }

    public SubModify getPrototype() {
        return prototype;
    }

    public Set<SubModify> getSubs() {
        return subs;
    }

    public String getTitle() {
        return title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

    public void setSubs(Set<SubModify> subs) {
        this.subs = subs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestModify.Modify with() {
        return new TestModifyModifyImpl(this);
    }

    @SuppressWarnings("unchecked")
    protected class TestModifyModifyImpl extends BaseModifierImpl<TestModify.Modify, TestModify> implements TestModify.Modify {

        protected TestModifyModifyImpl(TestModify parent) {
            super(parent);
        }

        public TestModify.Modify amount(double amount) {
            TestModifyImpl.this.amount = amount;
            return this;
        }

        public TestModify done() {
            return TestModifyImpl.this;
        }

        public TestModify.Modify items(List<Long> items) {
            TestModifyImpl.this.items = items;
            return this;
        }

        public CodeList items() {
            if (TestModifyImpl.this.items == null) {
                TestModifyImpl.this.items = new java.util.ArrayList<>();
            }
            return new CodeListImpl<>(this, TestModifyImpl.this.items);
        }

        public TestModify.Modify prototype(SubModify prototype) {
            TestModifyImpl.this.prototype = prototype;
            return this;
        }

        public TestModify.Modify subs(Set<SubModify> subs) {
            TestModifyImpl.this.subs = subs;
            return this;
        }

        public EmbeddedCodeCollection subs() {
            if (TestModifyImpl.this.subs == null) {
                TestModifyImpl.this.subs = new java.util.HashSet<>();
            }
            return new EmbeddedCodeSetImpl<>(this, TestModifyImpl.this.subs, SubModify.class);
        }

        public TestModify.Modify title(String title) {
            TestModifyImpl.this.title = title;
            return this;
        }
    }
}

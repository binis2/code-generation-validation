/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;

@Generated(value = "SubModifyPrototype", comments = "SubModify")
public class SubModifyImpl implements SubModify, Modifiable<SubModify.Modify> {

    protected SubModify prototype;

    protected double subAmount;

    protected String subtitle;

    public SubModifyImpl() {
    }

    public SubModify getPrototype() {
        return prototype;
    }

    public double getSubAmount() {
        return subAmount;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubAmount(double subAmount) {
        this.subAmount = subAmount;
    }

    public void setSubtitle(String subtitle) {
        Validation.start("subtitle", subtitle).sanitize(TrimSanitizer.class).perform(v -> this.subtitle = v);
    }

    public SubModify.Modify with() {
        return new SubModifyModifyImpl();
    }

    protected static class EmbeddedSubModifyModifyImpl<T> implements SubModify.EmbeddedModify<T> {

        protected SubModifyImpl entity;

        protected T parent;

        protected EmbeddedSubModifyModifyImpl(T parent, SubModifyImpl entity) {
            this.parent = parent;
            this.entity = entity;
        }

        public EmbeddedCodeCollection<SubModify.EmbeddedModify<T>, SubModify, T> and() {
            return (EmbeddedCodeCollection) parent;
        }

        public SubModify.EmbeddedModify<T> prototype(SubModify prototype) {
            entity.prototype = prototype;
            return this;
        }

        public SubModify.EmbeddedModify<T> subAmount(double subAmount) {
            entity.subAmount = subAmount;
            return this;
        }

        public SubModify.EmbeddedModify<T> subtitle(String subtitle) {
            Validation.start("subtitle", subtitle).sanitize(TrimSanitizer.class).perform(v -> entity.subtitle = v);
            return this;
        }
    }

    protected class SubModifyModifyImpl implements SubModify.Modify {

        public SubModify done() {
            return SubModifyImpl.this;
        }

        public SubModify.Modify prototype(SubModify prototype) {
            SubModifyImpl.this.prototype = prototype;
            return this;
        }

        public SubModify.Modify subAmount(double subAmount) {
            SubModifyImpl.this.subAmount = subAmount;
            return this;
        }

        public SubModify.Modify subtitle(String subtitle) {
            Validation.start("subtitle", subtitle).sanitize(TrimSanitizer.class).perform(v -> SubModifyImpl.this.subtitle = v);
            return this;
        }
    }
}

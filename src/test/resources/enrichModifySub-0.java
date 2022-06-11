/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
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

    public SubModify.Modify with() {
        return new SubModifyModifyImpl(this);
    }

    protected class SubModifyImplCollectionModifyImpl extends SubModifyImplEmbeddedModifyImpl implements SubModify.EmbeddedCollectionModify {

        protected SubModifyImplCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    protected class SubModifyImplEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements SubModify.EmbeddedModify<T, R> {

        protected SubModifyImplEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public T prototype(SubModify prototype) {
            SubModifyImpl.this.prototype = prototype;
            return (T) this;
        }

        public T subAmount(double subAmount) {
            SubModifyImpl.this.subAmount = subAmount;
            return (T) this;
        }

        public T subtitle(String subtitle) {
            Validation.start(this.getClass(), "subtitle", subtitle).sanitize(TrimSanitizer.class).perform(v -> SubModifyImpl.this.subtitle = v);
            return (T) this;
        }
    }

    protected class SubModifyModifyImpl extends SubModifyImplEmbeddedModifyImpl<SubModify.Modify, SubModify> implements SubModify.Modify {

        protected SubModifyModifyImpl(SubModify parent) {
            super(parent);
        }
    }
}

/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.validation.validator.RangeValidator;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.collection.EmbeddedCodeCollection;
import javax.annotation.processing.Generated;
import java.util.function.Consumer;

@Generated(value = "net.binis.codegen.SubModifyPrototype", comments = "SubModify")
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

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubModifyImplCollectionModifyImpl extends SubModifyImplEmbeddedModifyImpl implements SubModify.EmbeddedCollectionModify {

        protected SubModifyImplCollectionModifyImpl(Object parent) {
            super(parent);
        }

        public EmbeddedCodeCollection _and() {
            return (EmbeddedCodeCollection) parent;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubModifyImplEmbeddedModifyImpl<T, R> extends BaseModifierImpl<T, R> implements SubModify.EmbeddedModify<T, R> {

        protected SubModifyImplEmbeddedModifyImpl(R parent) {
            super(parent);
        }

        public SubModify.EmbeddedSoloModify<SubModify.EmbeddedModify<T, R>> prototype() {
            if (SubModifyImpl.this.prototype == null) {
                SubModifyImpl.this.prototype = CodeFactory.create(SubModify.class);
            }
            return CodeFactory.modify(this, SubModifyImpl.this.prototype, SubModify.class);
        }

        public T prototype(SubModify prototype) {
            SubModifyImpl.this.prototype = prototype;
            return (T) this;
        }

        public T subAmount(double subAmount) {
            Validation.start(this.getClass(), "subAmount", subAmount).validateWithMessages(RangeValidator.class, new String[] { "Value ({value}) for field '{field}' is less than {param[0]}!", "Value ({value}) for field '{field}' is more than {param[1]}!" }, 0, 10).perform(v -> SubModifyImpl.this.subAmount = v);
            return (T) this;
        }

        public T subtitle(String subtitle) {
            Validation.start(this.getClass(), "subtitle", subtitle).sanitize(TrimSanitizer.class).perform(v -> SubModifyImpl.this.subtitle = v);
            return (T) this;
        }
    }

    @SuppressWarnings("unchecked")
    @Generated("ModifierEnricher")
    protected class SubModifyImplSoloModifyImpl extends SubModifyImplEmbeddedModifyImpl implements SubModify.EmbeddedSoloModify {

        protected SubModifyImplSoloModifyImpl(Object parent) {
            super(parent);
        }
    }

    @Generated("ModifierEnricher")
    @SuppressWarnings("unchecked")
    protected class SubModifyModifyImpl extends SubModifyImplEmbeddedModifyImpl<SubModify.Modify, SubModify> implements SubModify.Modify {

        protected SubModifyModifyImpl(SubModify parent) {
            super(parent);
        }

        public SubModify.Modify prototype$(Consumer<SubModify.Modify> init) {
            if (SubModifyImpl.this.prototype == null) {
                SubModifyImpl.this.prototype = CodeFactory.create(SubModify.class);
            }
            init.accept(SubModifyImpl.this.prototype.with());
            return this;
        }
    }
}

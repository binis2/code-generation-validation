package net.binis.codegen.validation.flow.impl.base;

/*-
 * #%L
 * code-generator-validation
 * %%
 * Copyright (C) 2021 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import net.binis.codegen.exception.ValidationException;
import net.binis.codegen.exception.ValidationFormException;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.objects.Pair;
import net.binis.codegen.validation.*;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.flow.ValidationStart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static net.binis.codegen.tools.Reflection.instantiate;

public abstract class BaseValidationFlow implements Validation, ValidationStart {

    protected Object value;
    protected String field;
    protected List<Pair<String, String>> errors;
    protected Class<?> cls;

    @SuppressWarnings("unchecked")
    @Override
    public Validation validate(Class intf, String message, Object... params) {
        var entry = CodeFactory.lookup(intf);
        if (isNull(entry) && !intf.isInterface()) {
            instantiate(intf);
            entry = CodeFactory.lookup(intf);
        }
        if (nonNull(entry)) {
            var obj = CodeFactory.create(intf);
            if (obj instanceof Validator) {
                if (!((Validator) obj).validate(value, params)) {
                    handleValidationError(field, value, message, params);
                }
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not validator!");
            }
        } else {
            throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not registered!");
        }

        return this;
    }

    @Override
    public Validation validateWithMessages(Class intf, String[] messages, Object... params) {
        var entry = CodeFactory.lookup(intf);
        if (isNull(entry) && !intf.isInterface()) {
            instantiate(intf);
            entry = CodeFactory.lookup(intf);
        }
        if (nonNull(entry)) {
            var obj = CodeFactory.create(intf);
            if (obj instanceof ValidatorWithMessages) {
                var validator = (ValidatorWithMessages) obj;
                var result = validator.validate(value, params);
                if (!result.result()) {
                    handleValidationError(field, value, messages[result.error()], params);
                }
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not validator!");
            }
        } else {
            throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not registered!");
        }

        return this;
    }


    @SuppressWarnings("unchecked")
    @Override
    public Validation sanitize(Class intf, Object... params) {
        var entry = CodeFactory.lookup(intf);
        if (isNull(entry) && !intf.isInterface()) {
            instantiate(intf);
            entry = CodeFactory.lookup(intf);
        }
        if (nonNull(entry)) {
            var obj = CodeFactory.create(intf);
            if (obj instanceof Sanitizer) {
                value = ((Sanitizer) obj).sanitize(value, params);
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not sanitizer!");
            }
        } else {
            throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not registered!");
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Validation execute(Class intf, String message, Object... params) {
        var entry = CodeFactory.lookup(intf);
        if (isNull(entry) && !intf.isInterface()) {
            instantiate(intf);
            entry = CodeFactory.lookup(intf);
        }
        if (nonNull(entry)) {
            var obj = CodeFactory.create(intf);
            if (obj instanceof Executor) {
                if (!((Executor) obj).execute(value, params)) {
                    handleValidationError(field, value, message, params);
                }
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not executor!");
            }
        } else {
            throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not registered!");
        }

        return this;
    }

    @Override
    public Validation errors(List list) {
        this.errors = list;
        return this;
    }

    @Override
    public Validation cls(Class cls) {
        this.cls = cls;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> Validation<T> start(String field, T value) {
        this.field = field;
        this.value = value;
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void perform(Consumer operation) {
        operation.accept(value);
    }

    @Override
    public void form(Class cls, Consumer... operations) {
        var all = new HashMap<String, List<String>>();
        for (var op : operations) {
            var err = new ArrayList<Pair<String, String>>();
            try {
                op.accept(err);
            } catch (ValidationException ex) {
                append(all, ex.getField(), ex.getMessage());
            } catch (Exception e) {
                if (err.isEmpty()) {
                    append(all, "<unknown>", e.getMessage());
                }
            }
            err.forEach(e -> append(all, e.getKey(), e.getValue()));
        }

        if (!all.isEmpty()) {
            throw new ValidationFormException(cls, all);
        }
    }

    @Override
    public Validation child() {
        if (nonNull(value) && value instanceof Validatable) {
            try {
                ((Validatable) value).validate();
            } catch (ValidationFormException ex) {
                var prefix = field + ".";
                ex.getErrors().forEach((key, val) ->
                        val.forEach(v ->
                                errors.add(Pair.of(prefix + key, v))));
            }
        }
        return this;
    }

    private void append(Map<String, List<String>> all, String field, String message) {
        var list = all.computeIfAbsent(field, k -> new ArrayList<>());
        list.add(message);
    }

    protected abstract void handleValidationError(String field, Object value, String message, Object... params);

}

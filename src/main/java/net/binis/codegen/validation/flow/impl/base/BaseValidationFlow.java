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
import net.binis.codegen.tools.Holder;
import net.binis.codegen.validation.*;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.flow.ValidationStart;
import net.binis.codegen.validation.message.ValidationMessageBuilder;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static net.binis.codegen.tools.Reflection.instantiate;

public abstract class BaseValidationFlow implements Validation, ValidationStart {

    protected Object value;
    protected String field;
    protected List<Pair<String, String>> errors;
    protected Class<?> cls;

    @Override
    public Validation validate(Class intf, String message, Object... params) {
        process(intf, obj -> {
            if (obj instanceof Validator validator) {
                internalValidate(validator, params, field, value, message);
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not validator!");
            }
        });

        return this;
    }

    @Override
    public Validation validateCollection(Class intf, String message, Object... params) {
        process(intf, obj -> {
            if (obj instanceof Validator validator) {
                processCollection((k, v) -> internalValidate(validator, params, field + k, v, message));
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not validator!");
            }
        });

        return this;
    }

    @Override
    public Validation validateWithMessages(Class intf, String[] messages, Object... params) {
        process(intf, obj -> {
            if (obj instanceof ValidatorWithMessages validator) {
                internalValidateWithMessages(messages, validator, params, field, value);
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not validator!");
            }
        });

        return this;
    }

    @Override
    public Validation validateWithMessagesCollection(Class intf, String[] messages, Object... params) {
        process(intf, obj -> {
            if (obj instanceof ValidatorWithMessages validator) {
                processCollection((k, v) -> internalValidateWithMessages(messages, validator, params, field + k, v));
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not validator!");
            }
        });

        return this;
    }

    @Override
    public Validation sanitize(Class intf, Object... params) {
        process(intf, obj -> {
            if (obj instanceof Sanitizer s) {
                value = s.sanitize(value, params);
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not sanitizer!");
            }
        });

        return this;
    }

    @Override
    public Validation sanitizeCollection(Class intf, Object... params) {
        process(intf, obj -> {
            if (obj instanceof Sanitizer s) {
                value = s.sanitize(value, params);
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not sanitizer!");
            }
        });

        return this;
    }

    @Override
    public Validation execute(Class intf, String message, Object... params) {
        process(intf, obj -> {
            if (obj instanceof Executor executor) {
                internalExecute(executor, params, field, value, message);
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not executor!");
            }
        });

        return this;
    }

    @Override
    public Validation executeCollection(Class intf, String message, Object... params) {
        process(intf, obj -> {
            if (obj instanceof Executor executor) {
                processCollection((k, v) -> internalExecute(executor, params, field + k, v, message));
            } else {
                throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not executor!");
            }
        });

        return this;
    }


    @SuppressWarnings("unchecked")
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
    public void perform() {
        //Do nothing
    }

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
    @Override
    public Validation child() {
        if (nonNull(value)) {
            if (value instanceof Validatable) {
                validateValue(value, () -> field + ".");
            } else if (value instanceof Collection c) {
                var idx = Holder.of(0);
                for (Object o : c) {
                    validateValue(o, () -> field + "[" + idx.get() + "].");
                    idx.set(idx.get() + 1);
                }
            } else if (value instanceof Map map) {
                map.forEach((key, val) -> {
                    if (key instanceof Validatable) {
                        validateValue(key, () -> field + ".key(" + key + ").");
                    }
                    if (val instanceof Validatable) {
                        validateValue(val, () -> field + "[\"" + key + "\"].");
                    }
                });
            }
        }
        return this;
    }

    protected void internalValidateWithMessages(String[] messages, ValidatorWithMessages validator, Object[] params, String title, Object value) {
        var result = validator.validate(value, params);
        if (!result.result()) {
            internalHandleValidationError(title, value, messages[result.error()], params);
        }
    }

    protected void internalValidate(Validator validator, Object[] params, String title, Object value, String message) {
        if (!validator.validate(value, params)) {
            internalHandleValidationError(title, value, message, params);
        }
    }

    protected void internalExecute(Executor executor, Object[] params, String title, Object value, String message) {
        if (!executor.execute(value, params)) {
            internalHandleValidationError(title, value, message, params);
        }
    }

    protected void processCollection(BiConsumer<String, Object> consumer) {
        if (value instanceof Collection<?> c) {
            var idx = 0;
            for (var item : c) {
                consumer.accept("[" + idx + "]", item);
                idx++;
            }
        } else if (value instanceof Map map) {
            throw new UnsupportedOperationException("Not implemented!");
//            map.keySet().forEach(key ->
//                    consumer.accept("[" + idx + "]", item));
        }
    }

    protected void validateValue(Object value, Supplier<String> prefix) {
        try {
            ((Validatable) value).validate();
        } catch (ValidationFormException ex) {
            ex.getErrors().forEach((key, val) ->
                    val.forEach(v ->
                            errors.add(Pair.of(prefix.get() + key, v))));
        }
    }

    @SuppressWarnings("unchecked")
    public void process(Class intf, Consumer consumer) {
        var entry = CodeFactory.lookup(intf);
        if (isNull(entry) && !intf.isInterface()) {
            instantiate(intf);
            entry = CodeFactory.lookup(intf);
        }
        if (nonNull(entry)) {
            consumer.accept(CodeFactory.create(intf));
        } else {
            throw new ValidationException(cls, intf.getSimpleName(), intf.getCanonicalName() + " is not registered!");
        }
    }

    protected void append(Map<String, List<String>> all, String field, String message) {
        var list = all.computeIfAbsent(field, k -> new ArrayList<>());
        list.add(message);
    }

    protected void internalHandleValidationError(String field, Object value, String message, Object... params) {
        handleValidationError(field, value, ValidationMessageBuilder.message(field, value, params, message), params);
    }

    protected abstract void handleValidationError(String field, Object value, String message, Object... params);

}

package net.binis.codegen.validation.flow;

/*-
 * #%L
 * code-generator-validation
 * %%
 * Copyright (C) 2021 - 2024 Binis Belev
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

import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.objects.Pair;

import java.util.List;
import java.util.function.Consumer;

public interface Validation<T> {

    String DEFAULT_FLOW_CLASS = "net.binis.codegen.validation.flow.impl.DefaultValidationFlow";

    Validation<T> validate(Class intf, String message, Object... params);
    Validation<T> validateWithMessages(Class intf, String[] messages, Object... params);
    Validation<T> execute(Class intf, String message, Object... params);
    Validation<T> sanitize(Class intf, Object... params);
    Validation<T> validateCollection(Class intf, String message, Object... params);
    Validation<T> validateWithMessagesCollection(Class intf, String[] messages, Object... params);
    Validation<T> executeCollection(Class intf, String message, Object... params);
    Validation<T> sanitizeCollection(Class intf, Object... params);
    Validation<T> errors(List<Pair<String, String>> list);
    Validation<T> child();
    Validation<T> cls(Class<?> cls);

    void perform(Consumer<T> operation);
    void perform();

    static <T> Validation<T> start(Class<?> cls, String field, T value) {
        return CodeFactory.createDefault(ValidationStart.class, DEFAULT_FLOW_CLASS).start(field, value).cls(cls);
    }

    @SuppressWarnings("unchecked")
    static <T> Validation<T> start(List errors, Class<?> cls, String field, T value) {
        return CodeFactory.createDefault(ValidationStart.class, DEFAULT_FLOW_CLASS).start(field, value).errors(errors).cls(cls);
    }

    @SuppressWarnings("unchecked")
    static void form(Class<?> cls, Consumer<List<Pair<String, String>>>... operations) {
        CodeFactory.createDefault(ValidationStart.class, DEFAULT_FLOW_CLASS).form(cls, operations);
    }

}

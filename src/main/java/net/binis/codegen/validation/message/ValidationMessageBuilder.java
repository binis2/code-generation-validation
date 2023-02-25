package net.binis.codegen.validation.message;

/*-
 * #%L
 * code-generator-validation
 * %%
 * Copyright (C) 2021 - 2023 Binis Belev
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
import net.binis.codegen.tools.BaseStringInterpolator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ValidationMessageBuilder extends BaseStringInterpolator<ValidationMessageBuilder.Message> {

    protected static final Map<String, Message> cache = new ConcurrentHashMap<>();

    public ValidationMessageBuilder() {
        CodeFactory.forceRegisterType(ValidationMessageBuilder.class, CodeFactory.lazy(ValidationMessageBuilder::new), null);
    }

    public static String message(Class cls, String field, Object value, Object[] params, String message) {
        if (nonNull(message)) {
            return cache.computeIfAbsent(message, k ->
                            CodeFactory.create(ValidationMessageBuilder.class).buildExpression(k))
                    .interpolate(cls, field, value, params);
        } else {
            return null;
        }
    }

    protected Message buildConstantExpression(String exp) {
        return (cls, field, value, params) -> exp;
    }

    protected Message buildComplexExpression(List<Message> list) {
        return (cls, field, value, params) -> {
            var result = new StringBuilder();
            for (var exp : list) {
                result.append(exp.interpolate(cls, field, value, params));
            }
            return result.toString();
        };
    }

    protected Message buildParamExpression(String exp) {
        if ("field".equals(exp)) {
            return (cls, field, value, params) -> field;
        } else if ("value".equals(exp)) {
            return (cls, field, value, params) -> isNull(value) ? "null" : value.toString();
        } else if (exp.startsWith("param[") && exp.endsWith("]")) {
            try {
                var idx = Integer.parseInt(exp.substring(6, exp.length() - 1));
                var e = "{" + exp + "}";
                return (cls, field, value, params) -> idx > -1 && idx < params.length ? params[idx].toString() : e;
            } catch (Exception e) {
                //Do nothing
            }
        } else if ("class".equals(exp)) {
            return (cls, field, value, params) -> cls.getSimpleName();
        } else if ("Class".equals(exp)) {
            return (cls, field, value, params) -> cls.getCanonicalName();
        }

        return buildConstantExpression("{" + exp + "}");
    }

    @FunctionalInterface
    protected interface Message {
        String interpolate(Class cls, String field, Object value, Object[] params);
    }

    public void cleanUp() {
        cache.clear();
    }

}

package net.binis.codegen.validation.validator;

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
import net.binis.codegen.validation.ValidatorWithMessages;
import net.binis.codegen.validation.flow.impl.ValidationResultImpl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import static java.util.Objects.nonNull;

public class LengthValidator implements ValidatorWithMessages {

    private static final LengthValidator instance = new LengthValidator();

    static {
        CodeFactory.registerType(LengthValidator.class, () -> instance, null);
    }

    @Override
    public ValidationResult validate(Object value, Object... params) {
        if (nonNull(value) && params.length == 2 && params[0] instanceof Integer && params[1] instanceof Integer) {
            var len = -1;
            if (value instanceof Collection collection) {
                len = collection.size();
            } else if (value instanceof Map map) {
                len = map.size();
            } else if (value.getClass().isArray()) {
                len = Array.getLength(value);
            } else {
                len = value.toString().length();
            }
            var min = (int) params[0];
            if (min > 0 && len < min) {
                return ValidationResultImpl.of(false);
            } else {
                var max = (int) params[1];
                if (max > -1 && len > max) {
                    return ValidationResultImpl.of(false, 1);
                }
            }
        }
        return ValidationResultImpl.of(true);
    }


}

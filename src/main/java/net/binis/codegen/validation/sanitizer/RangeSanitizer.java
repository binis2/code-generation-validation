package net.binis.codegen.validation.sanitizer;

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
import net.binis.codegen.validation.Sanitizer;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;

public class RangeSanitizer implements Sanitizer {

    private static final RangeSanitizer instance = new RangeSanitizer();

    {
        CodeFactory.registerType(RangeSanitizer.class, () -> instance, null);
    }

    @Override
    public <T> T sanitize(T value, Object... params) {
        if (nonNull(value) && value instanceof Number && params.length > 1) {
            var val = BigDecimal.valueOf(((Number) value).doubleValue());
            var min = params[0] instanceof String ? BigDecimal.valueOf(Double.parseDouble((String) params[0])) : BigDecimal.valueOf(((Number) params[0]).doubleValue());
            var max = params[1] instanceof String ? BigDecimal.valueOf(Double.parseDouble((String) params[1])) : BigDecimal.valueOf(((Number) params[1]).doubleValue());
            if (val.compareTo(min) < 0) {
                return convert(value, min);
            } else if (val.compareTo(max) > 0) {
                return convert(value, max);
            }
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    private <T> T convert(T value, BigDecimal val) {
        if (value instanceof Integer) {
            return (T) (Object) val.intValue();
        } else if (value instanceof Long) {
            return (T) (Object) val.longValue();
        } else if (value instanceof Double) {
            return (T) (Object) val.doubleValue();
        } else if (value instanceof Float) {
            return (T) (Object) val.floatValue();
        } else if (value instanceof Byte) {
            return (T) (Object) val.byteValue();
        } else if (value instanceof Short) {
            return (T) (Object) val.shortValue();
        }
        return value;
    }
}

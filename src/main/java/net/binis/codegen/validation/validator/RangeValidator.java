package net.binis.codegen.validation.validator;

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

import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.validation.ValidatorWithMessages;
import net.binis.codegen.validation.flow.impl.ValidationResultImpl;

import java.math.BigDecimal;

public class RangeValidator implements ValidatorWithMessages {

    private static final RangeValidator instance = new RangeValidator();

    {
        CodeFactory.registerType(RangeValidator.class, () -> instance, null);
    }

    public ValidationResult validate(Object value, Object... params) {
        if (value instanceof Number n && params.length == 2 && params[0] instanceof Number p1 && params[1] instanceof Number p2) {
            var val = BigDecimal.valueOf(n.doubleValue());
            var min = params[0] instanceof String p ? BigDecimal.valueOf(Double.parseDouble(p)) : BigDecimal.valueOf(p1.doubleValue());
            if (val.compareTo(min) < 0) {
                return ValidationResultImpl.of(false, 0);
            } else {
                var max = params[1] instanceof String p ? BigDecimal.valueOf(Double.parseDouble(p)) : BigDecimal.valueOf(p2.doubleValue());
                if (val.compareTo(max) > 0) {
                    return ValidationResultImpl.of(false, 1);
                }
            }
        }
        return ValidationResultImpl.of(true);
    }

}

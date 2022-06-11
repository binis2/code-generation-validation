package net.binis.codegen.validation.flow.impl;

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
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.validation.flow.ValidationStart;
import net.binis.codegen.validation.flow.impl.base.BaseValidationFlow;

import static java.util.Objects.isNull;

public class DefaultValidationFlow extends BaseValidationFlow {

    {
        CodeFactory.registerType(ValidationStart.class, DefaultValidationFlow::new, null);
    }

    @Override
    protected void handleValidationError(String field, Object value, String message, Object... params) {
        if (isNull(message)) {
            message = "Validation failed for field: %s!";
        }

        var p = new Object[params.length + 2];
        p[0] = field;
        p[1] = value;
        System.arraycopy(params, 0, p, 2, params.length);

        throw new ValidationException(String.format(message, p));
    }

}

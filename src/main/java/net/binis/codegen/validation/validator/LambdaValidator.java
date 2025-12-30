package net.binis.codegen.validation.validator;

/*-
 * #%L
 * code-generator-validation
 * %%
 * Copyright (C) 2021 - 2026 Binis Belev
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

import net.binis.codegen.annotation.validation.AsCode;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.validation.Validator;

import java.util.function.Predicate;

@AsCode("((java.util.function.Predicate<{type}>) %s)")
public class LambdaValidator implements Validator {

    private static final LambdaValidator instance = new LambdaValidator();

    static {
        CodeFactory.registerType(LambdaValidator.class, () -> instance, null);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean validate(Object value, Object... params) {
        return params.length > 0 && params[0] instanceof Predicate p && p.test(value);
    }

}

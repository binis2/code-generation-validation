package net.binis.codegen.validation.sanitizer;

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

import net.binis.codegen.annotation.validation.AsCode;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.validation.Sanitizer;

import java.util.function.Function;

@AsCode("((java.util.function.Function<{type}, {type}>) %s)")
public class LambdaSanitizer implements Sanitizer {

    private static final LambdaSanitizer instance = new LambdaSanitizer();

    {
        CodeFactory.registerType(LambdaSanitizer.class, () -> instance, null);
    }

    @Override
    public <T> T sanitize(T value, Object... params) {
        if (params.length > 0 && params[0] instanceof Function) {
            return (T) ((Function) params[0]).apply(value);
        }
        return value;
    }

}

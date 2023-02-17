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
import net.binis.codegen.validation.Validator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RegExValidator implements Validator {

    private static final RegExValidator instance = new RegExValidator();
    private static final Map<String, Pattern> cache = new ConcurrentHashMap<>();

    {
        CodeFactory.registerType(RegExValidator.class, () -> instance, null);
    }

    @Override
    public boolean validate(Object value, Object... params) {
        if (nonNull(value)) {
            var regex = (String) params[0];
            var pattern = cache.get(regex);

            if (isNull(pattern)) {
                pattern = Pattern.compile(regex);
                cache.put(regex, pattern);
            }

            return pattern.matcher(value.toString()).matches();
        }
        return true;
    }
}

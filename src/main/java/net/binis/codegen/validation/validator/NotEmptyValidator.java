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
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

public class NotEmptyValidator implements Validator {

    private static final NotEmptyValidator instance = new NotEmptyValidator();

    {
        CodeFactory.registerType(NotEmptyValidator.class, () -> instance, null);
    }

    public boolean validate(Object value, Object... params) {
        if (value instanceof Map<?, ?> map) {
            return !map.isEmpty();
        }
        if (value instanceof Collection<?> collection) {
            return !collection.isEmpty();
        }
        if (value instanceof String s) {
            return !StringUtils.isEmpty(s);
        }
        return true;
    }

}

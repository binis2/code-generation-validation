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

import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.objects.base.enumeration.CodeEnum;
import net.binis.codegen.validation.Validator;
import net.binis.codegen.validation.ValidatorWithMessages;
import net.binis.codegen.validation.flow.impl.ValidationResultImpl;

import static java.util.Objects.nonNull;

public class EnumValidator implements Validator {

    private static final EnumValidator instance = new EnumValidator();

    static {
        CodeFactory.registerType(EnumValidator.class, () -> instance, null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean validate(Object value, Object... params) {
        if (nonNull(value) && params.length == 1 && params[0] instanceof Class cls) {
            if (String.class.equals(value.getClass())) {
                return validateString(value, cls);
            } else if (Enum.class.isAssignableFrom(value.getClass())) {
                try {
                    Enum.valueOf(((Enum) value).getClass(), value.toString());
                    return true;
                } catch (Exception e) {
                    //Do nothing
                }

                return nonNull(CodeFactory.enumValueOf((Class<CodeEnum>) cls, value.toString()));
            } else if (CodeEnum.class.isAssignableFrom(value.getClass())) {
                return nonNull(CodeFactory.enumValueOf(value.getClass().isInterface() ? ((CodeEnum) value).getClass() : (Class) ((CodeEnum) value).getClass().getInterfaces()[0], value.toString()));
            } else {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private boolean validateString(Object value, Class cls) {
        if (Enum.class.isAssignableFrom(cls)) {
            try {
                Enum.valueOf(cls, value.toString());
                return true;
            } catch (Exception e) {
                //Do nothing
            }

            return nonNull(CodeFactory.enumValueOf((Class<CodeEnum>) cls, value.toString()));
        } else if (CodeEnum.class.isAssignableFrom(cls)) {
            return nonNull(CodeFactory.enumValueOf((Class<CodeEnum>) cls, value.toString()));
        }
        return false;
    }


}

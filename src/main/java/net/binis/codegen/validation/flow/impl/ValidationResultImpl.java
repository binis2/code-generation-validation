package net.binis.codegen.validation.flow.impl;

/*-
 * #%L
 * code-generator-validation
 * %%
 * Copyright (C) 2021 - 2022 Binis Belev
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

import net.binis.codegen.validation.ValidatorWithMessages;

public class ValidationResultImpl implements ValidatorWithMessages.ValidationResult {

    private boolean result;
    private int error;
    private boolean converted;
    private Object value;
    private Object[] params;

    @Override
    public boolean result() {
        return result;
    }

    @Override
    public int error() {
        return error;
    }

    @Override
    public boolean converted() {
        return converted;
    }

    @Override
    public Object value() {
        return value;
    }

    @Override
    public Object[] params() {
        return params;
    }

    public static ValidatorWithMessages.ValidationResult of(boolean result) {
        var r = new ValidationResultImpl();
        r.result = result;
        return r;
    }

    public static ValidatorWithMessages.ValidationResult of(boolean result, int error) {
        var r = new ValidationResultImpl();
        r.result = result;
        r.error = error;
        return r;
    }

    public static ValidatorWithMessages.ValidationResult of(boolean result, int error, Object value, Object[] params) {
        var r = new ValidationResultImpl();
        r.result = result;
        r.error = error;
        r.value = value;
        r.params = params;
        r.converted = true;
        return r;
    }

}

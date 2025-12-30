package net.binis;

/*-
 * #%L
 * code-generator
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

import net.binis.codegen.annotation.validation.AliasFor;
import net.binis.codegen.exception.ValidationException;
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseCodeGenTest;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.flow.impl.DefaultValidationFlow;
import net.binis.codegen.validation.validator.LengthValidator;
import net.binis.codegen.validation.validator.RangeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.mock.CodeGenMock.mockCreate;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RangeValidatorTest extends BaseCodeGenTest {

    @Test
    void test() {
        mockCreate(RangeValidator.class);
        mockCreate(DefaultValidationFlow.class);

        var messages = new String[] { "Value (%2$d) for field '%s' is less than %3$d!", "Value (%2$d) for field '%s' is more than %4$d!" };

        var validation = Validation.start(this.getClass(), "test", 5);
        assertThrows(ValidationException.class, () -> validation.validateWithMessages(RangeValidator.class, messages, -1, 2), "Value for field 'test' is longer than 2!");
        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", this).validateWithMessages(RangeValidator.class, messages, -1, 5));

        //TODO:
//        assertThrows(ValidationException.class, () -> validation.validateWithMessages(RangeValidator.class, messages, 5, 6), "Value for field 'test' is shorter than 5!");
//        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", this).validateWithMessages(RangeValidator.class, messages, 4, 5));
//
//
//        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", null).validateWithMessages(RangeValidator.class, null));
//        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", null).validateWithMessages(RangeValidator.class, new String[] {"test", "test2"}), "test");
//        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", 5).validateWithMessages(RangeValidator.class, null));
//        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", 5).validateWithMessages(RangeValidator.class, null, "5", "6"));
//        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", 6).validateWithMessages(RangeValidator.class, null, "5", "6"));
//        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", 4.99).validateWithMessages(RangeValidator.class, null, 5, 7));
//        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", 7.0001).validateWithMessages(RangeValidator.class, null, "5", "7"));
    }

}

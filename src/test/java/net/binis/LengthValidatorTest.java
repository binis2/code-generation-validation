package net.binis;

/*-
 * #%L
 * code-generator
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
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseTest;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.flow.impl.DefaultValidationFlow;
import net.binis.codegen.validation.validator.LengthValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.mock.CodeGenMock.mockCreate;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LengthValidatorTest extends BaseTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    void test() {
        mockCreate(LengthValidator.class);
        mockCreate(DefaultValidationFlow.class);
        var messages = new String[] { "Value for field '%s' is shorter than %4$d!", "Value for field '%s' is longer than %3$d!" };

        var validation = Validation.start(this.getClass(), "test", "asd");
        assertThrows(ValidationException.class, () -> validation.validateWithMessages(LengthValidator.class, messages, -1, 2), "Value for field 'test' is longer than 2!");
        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", this).validateWithMessages(LengthValidator.class, messages, -1, 5));

        assertThrows(ValidationException.class, () -> validation.validateWithMessages(LengthValidator.class, messages, 5, 6), "Value for field 'test' is shorter than 5!");
        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", this).validateWithMessages(LengthValidator.class, messages, 4, 5));

    }


}

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
import net.binis.codegen.validation.validator.RangeValidator;
import org.junit.Before;
import org.junit.Test;

import static net.binis.codegen.mock.CodeGenMock.mockCreate;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RangeValidatorTest extends BaseTest {

    @Before
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    public void test() {
        mockCreate(RangeValidator.class);
        mockCreate(DefaultValidationFlow.class);

        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", null).validate(RangeValidator.class, null));
        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", null).validate(RangeValidator.class, "test"), "test");
        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", 5).validate(RangeValidator.class, null));
        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", 5).validate(RangeValidator.class, null, "5", "6"));
        assertDoesNotThrow(() -> Validation.start(this.getClass(), "test", 6).validate(RangeValidator.class, null, "5", "6"));
        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", 4.99).validate(RangeValidator.class, null, 5, 7));
        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", 7.0001).validate(RangeValidator.class, null, "5", "7"));
    }


}

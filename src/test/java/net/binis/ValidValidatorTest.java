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
import net.binis.codegen.test.BaseCodeGenTest;
import net.binis.codegen.validation.Validatable;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.flow.impl.DefaultValidationFlow;
import net.binis.codegen.validation.validator.ValidValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.mock.CodeGenMock.mockCreate;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

class ValidValidatorTest extends BaseCodeGenTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    void test() {
        mockCreate(ValidValidator.class);
        mockCreate(DefaultValidationFlow.class);

        var value = mock(Validatable.class);

        Validation.start(this.getClass(), "test", value).validate(ValidValidator.class, null).perform();
        Validation.start(this.getClass(), "test", "test").validate(ValidValidator.class, null).perform();

        doThrow(new ValidationException(ValidValidatorTest.class, "test", "test")).when(value).validate();

        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", null).validate(ValidValidator.class, null));
        assertThrows(ValidationException.class, () -> Validation.start(this.getClass(), "test", value).validate(ValidValidator.class, null));
    }


}

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

import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseCodeGenTest;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.flow.impl.DefaultValidationFlow;
import net.binis.codegen.validation.sanitizer.LambdaSanitizer;
import net.binis.codegen.validation.sanitizer.OnlyNotNullsLambdaSanitizer;
import net.binis.codegen.validation.sanitizer.OnlyNullsLambdaSanitizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static net.binis.codegen.mock.CodeGenMock.mockCreate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LambdaSanitizerTest extends BaseCodeGenTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    void test() {
        mockCreate(LambdaSanitizer.class);
        mockCreate(DefaultValidationFlow.class);

        Validation.start(this.getClass(), "test", "test")
                .sanitize(LambdaSanitizer.class, ((Function<String, String>) String::toUpperCase))
                .perform(v -> assertEquals("TEST", v));
    }

    @Test
    void testOnlyNulls() {
        mockCreate(OnlyNullsLambdaSanitizer.class);
        mockCreate(DefaultValidationFlow.class);

        Validation.start(this.getClass(), "test", "test")
                .sanitize(OnlyNullsLambdaSanitizer.class, ((Function<String, String>) s -> "default"))
                .perform(v -> assertEquals("test", v));

        Validation.start(this.getClass(), "test", null)
                .sanitize(OnlyNullsLambdaSanitizer.class, ((Function<String, String>) s -> "default"))
                .perform(v -> assertEquals("default", v));

    }

    @Test
    void testOnlyNotNulls() {
        mockCreate(OnlyNotNullsLambdaSanitizer.class);
        mockCreate(DefaultValidationFlow.class);

        Validation.start(this.getClass(), "test", "test")
                .sanitize(OnlyNotNullsLambdaSanitizer.class, ((Function<String, String>) String::toUpperCase))
                .perform(v -> assertEquals("TEST", v));

        Validation.start(this.getClass(), "test", null)
                .sanitize(OnlyNotNullsLambdaSanitizer.class, ((Function<String, String>) String::toUpperCase))
                .perform(Assertions::assertNull);
    }

}

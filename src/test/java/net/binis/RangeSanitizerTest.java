package net.binis;

/*-
 * #%L
 * code-generator
 * %%
 * Copyright (C) 2021 - 2024 Binis Belev
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
import net.binis.codegen.validation.sanitizer.RangeSanitizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.binis.codegen.mock.CodeGenMock.mockCreate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeSanitizerTest extends BaseCodeGenTest {

    @BeforeEach
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    void test() {
        mockCreate(RangeSanitizer.class);
        mockCreate(DefaultValidationFlow.class);

        Validation.start(this.getClass(), "test", 5).sanitize(RangeSanitizer.class, "5", "6").perform(v -> assertEquals(5, v));
        Validation.start(this.getClass(), "test", 5.0).sanitize(RangeSanitizer.class, "5", "6").perform(v -> assertEquals(5.0, v));
        Validation.start(this.getClass(), "test", 5).sanitize(RangeSanitizer.class, 5.0, 6).perform(v -> assertEquals(5, v));
        Validation.start(this.getClass(), "test", 5).sanitize(RangeSanitizer.class, 6, "7").perform(v -> assertEquals(6, v));
        Validation.start(this.getClass(), "test", 8.0).sanitize(RangeSanitizer.class, 6, 7).perform(v -> assertEquals(7.0, v));
    }

}

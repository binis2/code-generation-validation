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

import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseTest;
import net.binis.codegen.validation.flow.Validation;
import net.binis.codegen.validation.flow.impl.DefaultValidationFlow;
import net.binis.codegen.validation.sanitizer.ReplaceSanitizer;
import net.binis.codegen.validation.sanitizer.TrimSanitizer;
import org.junit.Before;
import org.junit.Test;

import static net.binis.codegen.mock.CodeGenMock.mockCreate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplaceSanitizerTest extends BaseTest {

    @Before
    public void cleanUp() {
        Helpers.cleanUp();
    }

    @Test
    public void test() {
        mockCreate(ReplaceSanitizer.class);
        mockCreate(DefaultValidationFlow.class);

        Validation.start("test", " test  ").sanitize(ReplaceSanitizer.class, "\\s+", "").perform(v -> assertEquals("test", v));
        Validation.start("test", "test-test").sanitize(ReplaceSanitizer.class, "-", "+").perform(v -> assertEquals("test+test", v));
    }


}

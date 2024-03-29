package net.binis;

/*-
 * #%L
 * code-generator-validation
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

import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.validation.message.ValidationMessageBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationMessageBuilderTest {

    @BeforeEach
    void before() {
        CodeFactory.create(ValidationMessageBuilder.class).cleanUp();
    }

    @Test
    void test() {
        var msg = ValidationMessageBuilder.message(ValidationMessageBuilderTest.class, "field", "value", new Object[] {1, 2L, 3.0, 4.0f}, "({Class} ({class})) Field '{field}' with value '{value}' with params - [{param[0]},{param[1]},{param[2]},{param[3]},{param[4]},{param[5]}]");

        assertEquals("(net.binis.ValidationMessageBuilderTest (ValidationMessageBuilderTest)) Field 'field' with value 'value' with params - [1,2,3.0,4.0,{param[4]},{param[5]}]", msg);
    }

}

package net.binis;

/*-
 * #%L
 * code-generator-validation
 * %%
 * Copyright (C) 2021 - 2023 Binis Belev
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

import net.binis.codegen.exception.GenericCodeGenException;
import net.binis.codegen.test.BaseCodeGenTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TargetsTest extends BaseCodeGenTest {

    @Test
    void test() {
        testSingle("targets/targets1.java", "targets/targets1-0.java", "targets/targets1-1.java");
    }

    @Test
    void testFail() {
        assertThrows(GenericCodeGenException.class, () -> testSingle("targets/targets2.java", null, null));
    }

    @Test
    void testInlineTargetsFail() {
        assertThrows(GenericCodeGenException.class, () -> testSingle("targets/targets3.java", null, null));
    }

    @Test
    void testInlineTargetsArrayFails() {
        assertThrows(GenericCodeGenException.class, () -> testSingle("targets/targets4.java", null, null));
    }

}

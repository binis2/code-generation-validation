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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormTest extends BaseCodeGenTest {

    @Test
    void enrichForm() {
        testSingleExecute("enrichForm.java", "enrichForm-0.java", "enrichForm-1.java", "enrichForm-2.java");
    }

    @Test
    void enrichFormWithNested() {
        testSingle("enrichFormNested.java", "enrichFormNested-0.java", "enrichFormNested-1.java", 2);
    }

    @Test
    void enrichFormWithNested2() {
        testSingle("enrichFormNested2.java", "enrichFormNested2-0.java", "enrichFormNested2-1.java", 2);
    }

    @Test
    void enrichFormWithNestedCollection() {
        testSingle("enrichFormNestedCollection.java", "enrichFormNestedCollection-0.java", "enrichFormNestedCollection-1.java", 2);
    }


}

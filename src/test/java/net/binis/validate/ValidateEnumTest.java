package net.binis.validate;

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

import net.binis.codegen.test.BaseCodeGenTest;
import org.junit.jupiter.api.Test;

class ValidateEnumTest extends BaseCodeGenTest {


    @Test
    void enrichValidateEnum() {
        testSingleExecute("validate/enum/enrichValidateEnum.java", "validate/enum/enrichValidateEnum-0.java", "validate/enum/enrichValidateEnum-1.java", "validate/enum/enrichValidateEnum-2.java");
    }

}

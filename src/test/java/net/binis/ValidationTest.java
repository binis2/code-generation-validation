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

import net.binis.codegen.test.BaseCodeGenTest;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValidationTest extends BaseCodeGenTest {

    @Test
    void enrichValidate() {
        testSingle("enrichValidate.java", "enrichValidate-0.java", "enrichValidate-1.java");
    }

    @Test
    void enrichValidateModify() {
        testMulti(List.of(
                Triple.of("enrichModifySub.java", "enrichModifySub-0.java", "enrichModifySub-1.java"),
                Triple.of("enrichModify.java", "enrichModify-0.java", "enrichModify-1.java")
        ));
    }

    @Test
    void enrichValidateCustomAnnotations() {
        testSingle("enrichValidateCustomAnnotations.java", "enrichValidateCustomAnnotations-0.java", "enrichValidateCustomAnnotations-1.java");
    }

    @Test
    void enrichFluentWithValidate() {
        testSingle("enrichFluentWithValidate.java", "enrichFluentWithValidate-0.java", "enrichFluentWithValidate-1.java");
    }

    @Test
    void enrichValidateExecute() {
        testSingleExecute("enrichValidateExecute.java", "enrichValidateExecute-0.java", "enrichValidateExecute-1.java", "enrichValidateExecute-2.java");
    }

    @Test
    void enrichValidateValueWithAlias() {
        testSingle("enrichValidateValueWithAlias.java", "enrichValidateValueWithAlias-0.java", "enrichValidateValueWithAlias-1.java");
    }

    @Test
    void enrichValidateCollection() {
        testSingle("enrichValidateCollection.java", "enrichValidateCollection-0.java", "enrichValidateCollection-1.java");
    }

    @Test
    void enrichValidateEmbeddedCollection() {
        testSingleExecute("enrichValidateEmbeddedCollection.java", "enrichValidateEmbeddedCollection-0.java", "enrichValidateEmbeddedCollection-1.java", "enrichValidateEmbeddedCollection-2.java");
    }


    @Test
    void enrichValidateMixin() {
        testMulti(List.of(
                Triple.of("enrichValidateMixIn.java", "enrichValidateMixIn-0.java", "enrichValidateMixIn-1.java"),
                Triple.of("enrichValidateMixIn2.java", null, "enrichValidateMixIn2-1.java")
        ));
    }

    @Test
    void enrichValidateNested() {
        testSingle("enrichValidateNested.java", "enrichValidateNested-0.java", "enrichValidateNested-1.java", 2);
    }

    @Test
    void enrichValidateExecutorWithModifier() {
        testSingleExecute("enrichValidateExecuteWithModifier.java", "enrichValidateExecuteWithModifier-0.java", "enrichValidateExecuteWithModifier-1.java", "enrichValidateExecuteWithModifier-2.java");
    }

    @Test
    void enrichValidateExecutorAllBut() {
        testSingleExecute("enrichValidateExecuteAllBut.java", "enrichValidateExecuteAllBut-0.java", "enrichValidateExecuteAllBut-1.java", "enrichValidateExecuteAllBut-2.java");
    }


}

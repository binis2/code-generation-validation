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

import net.binis.codegen.exception.GenericCodeGenException;
import net.binis.codegen.generation.core.Helpers;
import net.binis.codegen.test.BaseCodeGenTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static net.binis.codegen.generation.core.Helpers.lookup;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnnotationValidationTest extends BaseCodeGenTest {

    @Test
    void annotationValidateCompiled() {
        lookup.registerExternalLookup(testSourcesLookup());
        testSingle("externalAnnotationValidate.java", "externalAnnotationValidate-0.java", "externalAnnotationValidate-1.java");
    }

    @Test
    void annotationValidate() {
        lookup.registerExternalLookup(s -> {
            if ("net.binis.codegen.annotations.ValidateJavaScriptInjection2".equals(s)) {
                try {
                    return Files.readString(Path.of("./src/test/java/" + s.replace('.', '/').substring(0, s.length() - 1) + ".java"));
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        });
        testSingleSkip("externalAnnotationValidate2.java", "externalAnnotationValidate2-0.java", "externalAnnotationValidate-1.java", true, false);
    }

    @Test
    void annotationValidateCompiledFailed() {
        lookup.registerExternalLookup(testSourcesLookup());
        assertThrows(GenericCodeGenException.class, () ->testSingle("externalAnnotationValidate3.java", null, null));
    }


}

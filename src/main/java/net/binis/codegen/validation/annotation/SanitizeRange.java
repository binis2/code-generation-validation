package net.binis.codegen.validation.annotation;

/*-
 * #%L
 * code-generator-core
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

import net.binis.codegen.annotation.CodeAnnotation;
import net.binis.codegen.annotation.validation.AliasFor;
import net.binis.codegen.annotation.validation.Sanitize;
import net.binis.codegen.validation.sanitizer.RangeSanitizer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@CodeAnnotation
@Target({ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Sanitize(RangeSanitizer.class)
public @interface SanitizeRange {
    @AliasFor("params")
    double min();
    @AliasFor("params")
    double max();
}

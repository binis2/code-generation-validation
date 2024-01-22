package net.binis.codegen.validation.annotation;

/*-
 * #%L
 * code-generator-core
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

import net.binis.codegen.annotation.CodeAnnotation;
import net.binis.codegen.annotation.validation.AliasFor;
import net.binis.codegen.annotation.validation.Validate;
import net.binis.codegen.validation.validator.LengthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@CodeAnnotation
@Target({ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Validate(LengthValidator.class)
public @interface ValidateLength {

    @AliasFor(value = "params")
    int min() default -1;

    @AliasFor(value = "params", order = 1)
    int max() default 255;

    @AliasFor(value = "params", order = 1, alternative = true)
    int value() default 255;

    @AliasFor(value = "messages")
    String minMessage() default "Value ({value}) for field '{field}' is shorter than {min}!";

    @AliasFor(value = "messages", order = 1)
    String maxMessage() default "Value ({value}) for field '{field}' is longer than {max}!";

}

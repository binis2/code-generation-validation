package net.binis.codegen.validation.executor;

/*-
 * #%L
 * code-generator-validation
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

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.annotation.validation.AsCode;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.validation.Executor;

import java.util.function.Consumer;

@Slf4j
@AsCode("((java.util.function.Consumer<{type}>) %s)")
public class LambdaExecutor implements Executor {

    private static final LambdaExecutor instance = new LambdaExecutor();

    {
        CodeFactory.registerType(LambdaExecutor.class, () -> instance, null);
    }

    @Override
    public boolean execute(Object value, Object... params) {
        return params.length > 0 && params[0] instanceof Consumer && executeInternal(params[0]);
    }

    private boolean executeInternal(Object value) {
        try {
            ((Consumer) value).accept(value);
            return true;
        } catch (Exception e) {
            log.warn("Execution failed!", e);
            return false;
        }
    }


}

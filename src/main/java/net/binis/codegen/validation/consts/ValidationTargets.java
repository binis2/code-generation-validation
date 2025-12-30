package net.binis.codegen.validation.consts;

/*-
 * #%L
 * code-generator-validation
 * %%
 * Copyright (C) 2021 - 2026 Binis Belev
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

import org.apache.commons.lang3.ArrayUtils;

public class ValidationTargets {

    public interface TargetsAware {
        Class<?>[] targets();
    }

    private ValidationTargets() {
    }

    public static class Primitives implements TargetsAware {

        private static final Class<?>[] classes = new Class[]{int.class, long.class, double.class, float.class, short.class, byte.class, boolean.class, char.class};

        @Override
        public Class<?>[] targets() {
            return classes;
        }
    }

    public static class Wrappers implements TargetsAware {

        private static final Class<?>[] classes = new Class[]{Integer.class, Long.class, Double.class, Float.class, Short.class, Byte.class, Boolean.class, Character.class};

        @Override
        public Class<?>[] targets() {
            return classes;
        }
    }

    public static class Common implements TargetsAware {

        private static final Class<?>[] classes = ArrayUtils.addAll(ArrayUtils.addAll(new Primitives().targets(), new Wrappers().targets()), String.class);
        @Override
        public Class<?>[] targets() {
            return classes;
        }
    }

    public static class WrapperNumbers implements TargetsAware {

        private static final Class<?>[] classes = new Class[]{Integer.class, Long.class, Double.class, Float.class, Short.class, Byte.class};

        @Override
        public Class<?>[] targets() {
            return classes;
        }
    }

    public static class PrimitiveNumbers implements TargetsAware {

        private static final Class<?>[] classes = new Class[]{int.class, long.class, double.class, float.class, short.class, byte.class};

        @Override
        public Class<?>[] targets() {
            return classes;
        }
    }

    public static class Numbers implements TargetsAware {

        private static final Class<?>[] classes = ArrayUtils.addAll(ArrayUtils.addAll(new PrimitiveNumbers().targets(), new WrapperNumbers().targets()), Number.class);

        @Override
        public Class<?>[] targets() {
            return classes;
        }
    }


}

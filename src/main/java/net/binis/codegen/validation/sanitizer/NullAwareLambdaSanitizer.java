package net.binis.codegen.validation.sanitizer;

import java.util.function.Function;

import static java.util.Objects.nonNull;

public class NullAwareLambdaSanitizer extends LambdaSanitizer {

    @Override
    public <T> T sanitize(T value, Object... params) {
        if (nonNull(value)) {
            return super.sanitize(value, params);
        }
        return value;
    }

}

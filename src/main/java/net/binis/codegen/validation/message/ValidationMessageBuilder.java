package net.binis.codegen.validation.message;

import net.binis.codegen.factory.CodeFactory;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ValidationMessageBuilder {

    protected static final String INVALID_EXPRESSION = "Invalid expression! ";

    protected static final Map<String, Message> cache = new ConcurrentHashMap<>();

    public ValidationMessageBuilder() {
        CodeFactory.forceRegisterType(ValidationMessageBuilder.class, CodeFactory.lazy(ValidationMessageBuilder::new), null);
    }

    public static String message(String field, Object value, Object[] params, String message) {
        return cache.computeIfAbsent(message, k ->
                        CodeFactory.create(ValidationMessageBuilder.class).buildExpression(k))
                .interpolate(field, value, params);
    }

    protected Message buildExpression(String exp) {
        var list = new ArrayList<Message>();
        var flag = true;
        var start = 0;
        for (var i = 0; i < exp.length(); i++) {
            if ('{' == exp.charAt(i)) {
                if (!flag) {
                    throw new InvalidParameterException(INVALID_EXPRESSION + exp);
                }

                if (start < i) {
                    var constant = exp.substring(start, i);
                    if (constant.length() != 0) {
                        list.add(buildConstantExpression(constant));
                    }
                }

                start = i + 1;

                flag = false;
            } else if ('}' == exp.charAt(i)) {
                if (flag) {
                    throw new InvalidParameterException(INVALID_EXPRESSION + exp);
                }

                if (start < i) {
                    var e = exp.substring(start, i);
                    list.add(buildParamExpression(e));
                }

                start = i + 1;

                flag = true;
            }

        }

        if (!flag) {
            throw new InvalidParameterException(INVALID_EXPRESSION + exp);
        }

        if (start < exp.length()) {
            list.add(buildConstantExpression(exp.substring(start)));
        }

        return buildComplexExpression(list);
    }

    protected Message buildConstantExpression(String exp) {
        return (field, value, params) -> exp;
    }

    protected Message buildComplexExpression(List<Message> list) {
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return (field, value, params) -> {
                var result = new StringBuilder();
                for (var exp : list) {
                    result.append(exp.interpolate(field, value, params));
                }
                return result.toString();
            };
        }
    }

    protected Message buildParamExpression(String exp) {
        if ("field".equals(exp)) {
            return (field, value, params) -> field;
        } else if ("value".equals(exp)) {
            return (field, value, params) -> isNull(value) ? "null" : value.toString();
        } else if (exp.startsWith("params[") && exp.endsWith("]")) {
            try {
                var idx = Integer.parseInt(exp.substring(7, exp.length() - 1));
                var e = "{" + exp + "}";
                return (field, value, params) -> idx > -1 && idx < params.length ? params[idx].toString() : e;
            } catch (Exception e) {
                //Do nothing
            }
        }

        return buildConstantExpression("{" + exp + "}");
    }

    protected static <R> R with(R object, Consumer<R> consumer) {
        if (nonNull(object)) {
            consumer.accept(object);
        }

        return object;
    }

    @FunctionalInterface
    protected interface Message {
        String interpolate(String field, Object value, Object[] params);
    }

    public void cleanUp() {
        cache.clear();
    }

}

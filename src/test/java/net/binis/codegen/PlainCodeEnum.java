/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.objects.base.enumeration.CodeEnum;
import net.binis.codegen.factory.CodeFactory;
import net.binis.codegen.annotation.Default;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.PlainCodeEnumPrototype", comments = "PlainCodeEnumImpl")
@net.binis.codegen.annotation.Generated(by = "net.binis.codegen.PlainCodeEnumPrototype")
@Default("net.binis.codegen.PlainCodeEnumImpl")
public interface PlainCodeEnum extends CodeEnum {

    static final PlainCodeEnum FIRST = CodeFactory.initializeEnumValue(PlainCodeEnum.class, "FIRST", 0);

    static final PlainCodeEnum SECOND = CodeFactory.initializeEnumValue(PlainCodeEnum.class, "SECOND", 1);

    static final PlainCodeEnum THIRD = CodeFactory.initializeEnumValue(PlainCodeEnum.class, "THIRD", 2);

    static PlainCodeEnum valueOf(String name) {
        return CodeFactory.enumValueOf(PlainCodeEnum.class, name);
    }

    static PlainCodeEnum valueOf(int ordinal) {
        return CodeFactory.enumValueOf(PlainCodeEnum.class, ordinal);
    }

    static PlainCodeEnum[] values() {
        return CodeFactory.enumValues(PlainCodeEnum.class);
    }
}

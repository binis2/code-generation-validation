package net.binis.codegen.validateenum;

import lombok.extern.slf4j.Slf4j;
import net.binis.codegen.PlainCodeEnum;
import net.binis.codegen.PlainEnum;
import net.binis.codegen.exception.ValidationException;
import net.binis.codegen.test.TestExecutor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
public class Execute extends TestExecutor {

    @Override
    public boolean execute() {

        TestEnum.create().plain(PlainEnum.FIRST).codeEnum(PlainCodeEnum.SECOND).str("THIRD").str2("FIRST").done();
        return true;
    }
}

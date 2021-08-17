package logic.parsersFactoryTests;

import consts.ExceptionConsts;
import consts.ParsersTypes;
import exceptions.ParserException;
import logic.CommandsParser;
import logic.ParsersFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParsersFactoryTestUnknownParser
{
    private ParsersFactory factory_ = null;
    @BeforeEach
    void setUp() {
        factory_ = new ParsersFactory();
    }

    @AfterEach
    void tearDown() {
        factory_ = null;
    }

    @Test
    void createOp() {
        CommandsParser parser;
        for (ParsersTypes type : ParsersTypes.values()) {
            try {
                parser = factory_.createParser(type);
            } catch (ParserException ex) {
                String expResProblem = ExceptionConsts.UNKNOWN_PARSER;
                String expResBadObjType = ExceptionConsts.BAD_PARSER;
                assertEquals(expResProblem, ex.getShortProblemDesc_());
                assertEquals(expResBadObjType, ex.getProblemObjectType_());
            }
        }
    }
}

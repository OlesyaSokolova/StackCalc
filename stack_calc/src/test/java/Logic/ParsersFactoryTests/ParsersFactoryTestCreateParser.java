package logic.parsersFactoryTests;

import consts.ParsersTypes;
import logic.CommandsParser;
import logic.ParsersFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParsersFactoryTestCreateParser {

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
    void createOp()
    {
        CommandsParser parser;
        for(ParsersTypes type: ParsersTypes.values())
        {
            try
            {
                parser = factory_.createParser(type);
                assertEquals(type, parser.getParserType());
                assertEquals(true, parser instanceof CommandsParser);
            }
            catch(exceptions.ParserException ex)
            {
                continue;
            }
        }
    }
}
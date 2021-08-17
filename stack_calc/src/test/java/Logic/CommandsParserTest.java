package logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandsParserTest {

    private FileParser parser;
    @BeforeEach
    void setUp() {
        parser =  new FileParser();
    }

    @AfterEach
    void tearDown() {
        parser = null;
    }
    @Test
    void parsingCommandDescriptions() {

        String[] testCommandsAndAruments = {"ADD", "DEFINE A 5", "DIF",
                "DIV", "MUL", "POP",
                "PRINT", "PUSH", "SQRT"};
        String[][] expCommandsAndAruments = {{"ADD"}, {"DEFINE",  "A", "5"}, {"DIF"},
                {"DIV"}, {"MUL"}, {"POP"},
                {"PRINT"}, {"PUSH"}, {"SQRT"}};
        for(String command: testCommandsAndAruments)
        {
            String[] commandWithArguments = parser.parseCommand(command);
            parser.addCommand(commandWithArguments);
        }
        assertEquals(expCommandsAndAruments.length, parser.getCommandsAndArguments_().size());
        for(int i =0; i < expCommandsAndAruments.length; i++)
        {
            assertEquals(expCommandsAndAruments[i].length, parser.getCommandsAndArguments_().get(i).length);
            for(int j = 0; j < expCommandsAndAruments[i].length; j++)
            {
                assertEquals(expCommandsAndAruments[i][j], parser.getCommandsAndArguments_().get(i)[j]);
            }
        }
    }
}
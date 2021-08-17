import logic.*;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestCalculator
{
    @Test
    public void testCalc()
    {
        CommandsParser parser = new FileParser();
        try {
            parser.parsingCommandDescriptions("instructionsTest.txt");
        }
        catch (java.io.IOException ex) {}
        OperationsFactory creator = new OperationsFactory();
        Executor executor = new Executor(parser.getCommandsAndArguments_(), creator);
        executor.start();
        Double expRes = 43.0;
        Double res = (double)executor.getResult();
        assertEquals(expRes, res);
    }
}


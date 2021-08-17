package operationDescripton;

import consts.OperationsNames;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {

    private Pop operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Pop(OperationsNames.POP);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution()
    {
        context.push(Math.random());
        try
        {
            operation.execution(context, null);

        }
        catch (exceptions.StackCalcException ex)
        {

        }
        double expRes = 0;
        double res = context.getDataElementsNumber();
        assertEquals(expRes, res);
    }
}
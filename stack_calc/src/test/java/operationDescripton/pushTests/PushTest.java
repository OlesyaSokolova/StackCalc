package operationDescripton.pushTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import exceptions.StackCalcException;
import operationDescripton.Push;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    private Push operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Push(OperationsNames.PUSH);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution()
    {
        Object[] arguments = {Math.random()};
        double contextSizeBeforeOPeration = context.getDataElementsNumber();
        try
        {
            operation.execution(context, arguments);
        }
        catch (StackCalcException ex) {
        }
        double expRes = contextSizeBeforeOPeration + UsefulConsts.PUSH_ARGUMENTS_NUMBER;
        double res = context.getDataElementsNumber();
        assertEquals(expRes, res);
    }

}
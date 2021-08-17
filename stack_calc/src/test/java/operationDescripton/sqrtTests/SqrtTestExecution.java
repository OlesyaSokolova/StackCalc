package operationDescripton.sqrtTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import operationDescripton.Sqrt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTestExecution {

    private Sqrt operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Sqrt(OperationsNames.SQRT);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution()
    {
        Double[] args = new Double[UsefulConsts.SQRT_ARGUMENTS_NUMBER];
        for(int i = 0; i < UsefulConsts.SQRT_ARGUMENTS_NUMBER; i++)
        {
            args[i] = Math.random();
        }
        context.push(args[UsefulConsts.FIRST_ARGUMENT_INDEX]);
        try
        {
            operation.execution(context, null);

        }
        catch (exceptions.StackCalcException ex)
        {
        }
        double expRes = Math.sqrt(args[UsefulConsts.FIRST_ARGUMENT_INDEX]);
        double res = (double)context.getTopElements(UsefulConsts.FIRST_VALUE_INDEX)[UsefulConsts.FIRST_ARGUMENT_INDEX];
        assertEquals(expRes, res);
    }
}
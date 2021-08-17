package operationDescripton.divTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import exceptions.StackCalcException;
import operationDescripton.Div;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivTestExecution {

    private Div operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Div(OperationsNames.DIV);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution()
    {
        Double[] args = new Double[UsefulConsts.DIV_ARGUMENTS_NUMBER];
        for(int i = 0; i < UsefulConsts.DIV_ARGUMENTS_NUMBER; i++)
        {
            args[i] = Math.random();
        }
        context.push(args[UsefulConsts.DENOMINATOR_INDEX]);
        context.push(args[UsefulConsts.NUMERATOR_INDEX]);
        try
        {
            operation.execution(context, null);

        }
        catch (StackCalcException ex) {
        }
        double expRes = args[UsefulConsts.NUMERATOR_INDEX]/args[UsefulConsts.DENOMINATOR_INDEX];
        double res = (double)context.getTopElements(UsefulConsts.FIRST_VALUE_INDEX)[UsefulConsts.FIRST_ARGUMENT_INDEX];
        assertEquals(expRes, res);
    }
}
package operationDescripton.mulTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import exceptions.StackCalcException;
import operationDescripton.Mul;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MulTestExecution {

    private Mul operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Mul(OperationsNames.MUL);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution()
    {
        Double[] args = new Double[UsefulConsts.MUL_ARGUMENTS_NUMBER];
        for(int i = 0; i < UsefulConsts.MUL_ARGUMENTS_NUMBER; i++)
        {
            args[i] = Math.random();
        }
        context.push(args[UsefulConsts.FIRST_ARGUMENT_INDEX]);
        context.push(args[UsefulConsts.SECOND_ARGUMENT_INDEX]);
        try
        {
            operation.execution(context, null);

        }catch (StackCalcException ex) {
        }
        double expRes = args[UsefulConsts.FIRST_ARGUMENT_INDEX]*args[UsefulConsts.SECOND_ARGUMENT_INDEX];
        double res = (double)context.getTopElements(UsefulConsts.FIRST_VALUE_INDEX)[UsefulConsts.FIRST_ARGUMENT_INDEX];
        assertEquals(expRes, res);
    }
}
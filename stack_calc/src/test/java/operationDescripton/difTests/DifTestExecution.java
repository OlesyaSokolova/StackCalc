package operationDescripton.difTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import operationDescripton.Dif;
import exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifTestExecution {

    private Dif operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Dif(OperationsNames.DIF);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution()
    {
        Double[] args = new Double[UsefulConsts.DIF_ARGUMENTS_NUMBER];
        for(int i = 0; i < UsefulConsts.DIF_ARGUMENTS_NUMBER; i++)
        {
            args[i] = Math.random();
        }
        context.push(args[UsefulConsts.SUBTRAHEND_INDEX]);
        context.push(args[UsefulConsts.MINUEND_INDEX]);
        try
        {
            operation.execution(context, null);

        }
        catch (StackCalcException ex) {
        }
        double expRes = args[UsefulConsts.MINUEND_INDEX]-args[UsefulConsts.SUBTRAHEND_INDEX];
        double res = (double)context.getTopElements(UsefulConsts.FIRST_VALUE_INDEX)[UsefulConsts.FIRST_ARGUMENT_INDEX];
        assertEquals(expRes, res);
    }
}
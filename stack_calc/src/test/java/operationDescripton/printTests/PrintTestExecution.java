package operationDescripton.printTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import operationDescripton.Print;
import exceptions.StackCalcException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintTestExecution {

    private Print operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Print(OperationsNames.PRINT);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution()
    {
        Double expRes = Math.random();
        context.push(expRes);
        try
        {
            operation.execution(context, null);

        }
        catch (StackCalcException ex) {
        }
        Double res = (Double)context.getTopElements(UsefulConsts.FIRST_VALUE_INDEX)[UsefulConsts.FIRST_ARGUMENT_INDEX];
        assertEquals(expRes.toString(), res.toString());
    }
}
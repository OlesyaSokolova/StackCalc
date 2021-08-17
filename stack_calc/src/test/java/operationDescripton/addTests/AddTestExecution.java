package operationDescripton.addTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import exceptions.StackCalcException;
import operationDescripton.Add;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTestExecution {

    private Add operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Add(OperationsNames.ADD);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void execution() {
        Double[] args = new Double[UsefulConsts.ADD_ARGUMENTS_NUMBER];
        for (int i = 0; i < UsefulConsts.ADD_ARGUMENTS_NUMBER; i++) {
            args[i] = Math.random();
        }
        context.push(args[UsefulConsts.FIRST_ARGUMENT_INDEX]);
        context.push(args[UsefulConsts.SECOND_ARGUMENT_INDEX]);
        try {
            operation.execution(context, null);
        }
        catch (StackCalcException ex) {
        }
        double expRes = args[UsefulConsts.FIRST_ARGUMENT_INDEX] + args[UsefulConsts.SECOND_ARGUMENT_INDEX];
        double res = (double) context.getTopElements(UsefulConsts.FIRST_VALUE_INDEX)[UsefulConsts.FIRST_ARGUMENT_INDEX];
        assertEquals(expRes, res);
    }
}
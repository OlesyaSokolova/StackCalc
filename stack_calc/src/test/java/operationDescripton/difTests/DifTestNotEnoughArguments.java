package operationDescripton.difTests;

import consts.ExceptionConsts;
import consts.OperationsNames;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import operationDescripton.Dif;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DifTestNotEnoughArguments
{
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
    void execution() {

        context.clear();
        try
        {
            operation.execution(context, null);
        }
        catch (exceptions.ArgumentException ex)
        {
            String expResProblem = ExceptionConsts.NO_ENOUGH_ARGUMENTS;
            String expResOpName = OperationsNames.DIF;
            String expResBadObjType =  ExceptionConsts.PROBLEM_WITH_ARGUMENT;
            assertEquals(expResProblem, ex.getShortProblemDesc_());
            assertEquals(expResOpName, ex.getProblemObjectName_());
            assertEquals(expResBadObjType, ex.getProblemObjectType_());
        }
    }
}
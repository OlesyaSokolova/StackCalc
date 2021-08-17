package operationDescripton.mulTests;

import consts.ExceptionConsts;
import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import operationDescripton.Mul;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MulTestNotEnoughArguments
{
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

        }
        catch (exceptions.ArgumentException ex)
        {
            String expResProblem = ExceptionConsts.NO_ENOUGH_ARGUMENTS;
            String expResOpName = OperationsNames.MUL;
            String expResBadObjType =  ExceptionConsts.PROBLEM_WITH_ARGUMENT;
            assertEquals(expResProblem, ex.getShortProblemDesc_());
            assertEquals(expResOpName, ex.getProblemObjectName_());
            assertEquals(expResBadObjType, ex.getProblemObjectType_());
        }
    }
}
package operationDescripton;

import consts.ExceptionConsts;
import consts.OperationsNames;
import data.ExecutionContext;
import exceptions.ArgumentException;
import exceptions.CommandException;
import logic.OperationsFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationValidateTest {

    private Operation[] operations_;
    ExecutionContext context_ = null;

    @BeforeEach
    void setUp()
    {
        String[] operationsForTheTest_ = {OperationsNames.MUL,
                OperationsNames.ADD, OperationsNames.DIV,
                OperationsNames.POP, OperationsNames.SQRT,
                OperationsNames.DIF, OperationsNames.PRINT };
        OperationsFactory factory = new OperationsFactory();
        operations_ = new Operation[operationsForTheTest_.length];
        for(int i = 0; i < operationsForTheTest_.length; i++)
        {
            try
            {
                operations_[i] = factory.createOp(operationsForTheTest_[i]);
            }
            catch(CommandException ex)
            {
                continue;
            }
        }
        factory = null;
    }

    @AfterEach
    void tearDown()
    {
        operations_ = null;
    }

    @Test
    void validate()
    {
        Object[] fakeArguments = {Math.random(), Math.random()};
        for(int i = 0; i < operations_.length; i++)
        {
            try
            {
                operations_[i].validate(context_, fakeArguments);
            }
            catch (ArgumentException ex)
            {
                String expResProblem = ExceptionConsts.TOO_MANY_ARGUMENTS;
                String expResOpName = operations_[i].getOperationName_();
                String expResBadObjType = ExceptionConsts.PROBLEM_WITH_ARGUMENT;
                assertEquals(expResProblem, ex.getShortProblemDesc_());
                assertEquals(expResOpName, ex.getProblemObjectName_());
                assertEquals(expResBadObjType, ex.getProblemObjectType_());
            }
        }
    }
}
package operationDescripton.pushTests;

import consts.ExceptionConsts;
import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import exceptions.ArgumentException;
import operationDescripton.Push;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.UniqueIdSelector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PushTestTooManyArguments {

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
    void validateNotEnoughArguments() {
        Object[] args = new Object[5];
        try {
            operation.validate(context, args);
        }
        catch (ArgumentException ex)
        {
            String expResProblem = ExceptionConsts.TOO_MANY_ARGUMENTS;
            String expResOpName = operation.getOperationName_();
            String expResBadObjType =  ExceptionConsts.PROBLEM_WITH_ARGUMENT;
            assertEquals(expResProblem, ex.getShortProblemDesc_());
            assertEquals(expResOpName, ex.getProblemObjectName_());
            assertEquals(expResBadObjType, ex.getProblemObjectType_());
        }
    }
}
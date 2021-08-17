package operationDescripton.defineTests;

import consts.ExceptionConsts;
import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import exceptions.ArgumentException;
import operationDescripton.Define;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefineTestNotEnoughArguments {

    private Define operation;
    private ExecutionContext context;

    @BeforeEach
    void setUp() {
        operation = new Define(OperationsNames.DEFINE);
        context = new ExecutionContextImpl();
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }

    @Test
    void validateNotEnoughArguments() {
        Object[] args = new Object[UsefulConsts.DEFINE_ARGUMENTS_NUMBER-1];
        Double value = Math.random();
        args[UsefulConsts.VALUE_NAME_INDEX] = "Value_Name";
        try {
            operation.validate(context, args);
        }
        catch (ArgumentException ex)
        {
            String expResProblem = ExceptionConsts.NO_ENOUGH_ARGUMENTS;
            String expResOpName = operation.getOperationName_();
            String expResBadObjType =  ExceptionConsts.PROBLEM_WITH_ARGUMENT;
            assertEquals(expResProblem, ex.getShortProblemDesc_());
            assertEquals(expResOpName, ex.getProblemObjectName_());
            assertEquals(expResBadObjType, ex.getProblemObjectType_());
        }
    }
}
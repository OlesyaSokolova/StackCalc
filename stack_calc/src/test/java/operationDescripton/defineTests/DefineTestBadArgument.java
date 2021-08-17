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

class DefineTestBadArgument {

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
    void validateTooManyArguments() {
        Object[] args = new Object[UsefulConsts.DEFINE_ARGUMENTS_NUMBER];
        String value = "bad value";
        args[UsefulConsts.VALUE_NAME_INDEX] = "Value_Name";
        args[UsefulConsts.VALUE_INDEX] = value;
        try {
            operation.execution(context, args);
        }
        catch (ArgumentException ex)
        {
            String expResProblem =  ExceptionConsts.SHOW_ARGUMENT + value + UsefulConsts.LINE_DELIMITER + ExceptionConsts.BAD_ARGUMENT +
                    UsefulConsts.LINE_DELIMITER + ExceptionConsts.AND_ANOTHER_PROBLEM + ExceptionConsts.UNDEFINED_VALUE;
            String expResOpName = OperationsNames.DEFINE;
            String expResBadObjType =  ExceptionConsts.PROBLEM_WITH_ARGUMENT;
            assertEquals(expResProblem, ex.getShortProblemDesc_());
            assertEquals(expResOpName, ex.getProblemObjectName_());
            assertEquals(expResBadObjType, ex.getProblemObjectType_());
        }
    }
}
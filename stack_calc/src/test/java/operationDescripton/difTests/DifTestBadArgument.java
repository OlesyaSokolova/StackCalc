package operationDescripton.difTests;

import consts.ExceptionConsts;
import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import operationDescripton.Dif;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DifTestBadArgument
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

        context.push(Math.random());
        context.push("hi i'm a bad argument ehhehehehheheeh");
        try {
            operation.execution(context, null);
        } catch (exceptions.ArgumentException ex) {
            String expResProblem = "For input string: \"hi i'm a bad argument ehhehehehheheeh\"" +
                    UsefulConsts.LINE_DELIMITER + ExceptionConsts.UNDEFINED_VALUE;
            String expResOpName = OperationsNames.DIF;
            String expResBadObjType = ExceptionConsts.PROBLEM_WITH_ARGUMENT;
            assertEquals(expResProblem, ex.getShortProblemDesc_());
            assertEquals(expResOpName, ex.getProblemObjectName_());
            assertEquals(expResBadObjType, ex.getProblemObjectType_());
        }
    }
}

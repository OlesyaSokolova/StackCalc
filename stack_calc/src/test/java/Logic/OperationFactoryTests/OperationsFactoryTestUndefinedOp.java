package logic.operationFactoryTests;

import consts.ExceptionConsts;
import exceptions.CommandException;
import logic.OperationsFactory;
import operationDescripton.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsFactoryTestUndefinedOp {

    private OperationsFactory factory_ = null;
    @BeforeEach
    void setUp() {
        factory_ = new OperationsFactory();
    }

    @AfterEach
    void tearDown() {
        factory_ = null;
    }

    @Test
    void createOp()
    {
        Operation op;
        String unknownName = "Integral";
        try
        {
            op = factory_.createOp(unknownName);
        }
        catch(CommandException ex)
        {
            String expResProblem = ExceptionConsts.UNKNOWN_OPERATION;
            String expResBadObjType =  ExceptionConsts.BAD_OPERATION;
            assertEquals(expResProblem, ex.getShortProblemDesc_());
            assertEquals(expResBadObjType, ex.getProblemObjectType_());
        }
    }
}

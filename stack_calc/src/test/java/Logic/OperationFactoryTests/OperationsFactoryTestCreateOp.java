package logic.operationFactoryTests;

import consts.OperationsNames;
import exceptions.CommandException;
import logic.OperationsFactory;
import operationDescripton.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsFactoryTestCreateOp {

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
            String[] operationsForTheTest_ = {OperationsNames.MUL,
                    OperationsNames.ADD, OperationsNames.DIV,
                    OperationsNames.POP, OperationsNames.SQRT,
                    OperationsNames.DIF, OperationsNames.PRINT,
                   OperationsNames.DEFINE, OperationsNames.PUSH};
            Operation op;
            for(int i = 0; i < operationsForTheTest_.length; i++)
            {
                try
                {
                    op = factory_.createOp(operationsForTheTest_[i]);
                    assertEquals(operationsForTheTest_[i], op.getOperationName_());
                    assertEquals(true, op instanceof Operation);
                }
                catch(CommandException ex)
                {
                    continue;
                }
            }
    }
}
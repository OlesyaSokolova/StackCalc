package operationDescripton.defineTests;

import consts.OperationsNames;
import consts.UsefulConsts;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import exceptions.StackCalcException;
import operationDescripton.Define;
import operationDescripton.Push;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefineTestExecution {

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
    void execution() {
        Object[] args = new Object[UsefulConsts.DEFINE_ARGUMENTS_NUMBER];
        Double value = Math.random();
        args[UsefulConsts.VALUE_NAME_INDEX] = "Value_Name";
        args[UsefulConsts.VALUE_INDEX] = value;
        try {
            operation.execution(context, args);
        }
        catch (StackCalcException ex) {
        }
        assertEquals(value,context.getDefinedValue("Value_Name"));
    }
}
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

class DefineTestRecursion {

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
        Object[] args0 = new Object[UsefulConsts.DEFINE_ARGUMENTS_NUMBER];
        Double value = Math.random();
        args0[UsefulConsts.VALUE_NAME_INDEX] = "Value_Name0";
        args0[UsefulConsts.VALUE_INDEX] = value;
        try {
            operation.execution(context, args0);
        }
        catch (StackCalcException ex) {
        }
        Object[] args1 = new Object[UsefulConsts.DEFINE_ARGUMENTS_NUMBER];
        args1[UsefulConsts.VALUE_NAME_INDEX] = "Value_Name1";
        args1[UsefulConsts.VALUE_INDEX] = args0[UsefulConsts.VALUE_NAME_INDEX];
        try {
            operation.execution(context, args1);
        }
        catch (StackCalcException ex) {
        }
        Object[] args2 = new Object[UsefulConsts.DEFINE_ARGUMENTS_NUMBER];
        args2[UsefulConsts.VALUE_NAME_INDEX] = "Value_Name2";
        args2[UsefulConsts.VALUE_INDEX] = args1[UsefulConsts.VALUE_NAME_INDEX];
        try {
            operation.execution(context, args2);
        }
        catch (StackCalcException ex) {
        }
        assertEquals(value,context.getDefinedValue("Value_Name2"));
    }
}
package operationDescripton;

import data.*;
import exceptions.ArgumentException;
import exceptions.CalculatingException;
import consts.*;
import java.lang.Object;


public class Push extends Operation
{
    public Push(String opName)
    {
        super(opName);
    }

    @Override
    public void execution(ExecutionContext data, Object[] arguments) throws CalculatingException, ArgumentException
    {
        String argumentString = arguments[UsefulConsts.FIRST_ARGUMENT_INDEX].toString();
        Double value = (Double)data.getDefinedValue(argumentString);
        if (value == null) {
            try {
                value = Double.valueOf(argumentString);
            } catch (java.lang.NumberFormatException formatEx) {
                throw new ArgumentException(operationName_,
                        ExceptionConsts.SHOW_ARGUMENT + argumentString + UsefulConsts.LINE_DELIMITER + ExceptionConsts.BAD_ARGUMENT +
                                UsefulConsts.LINE_DELIMITER + ExceptionConsts.AND_ANOTHER_PROBLEM + ExceptionConsts.UNDEFINED_VALUE);
            }
        }
        data.push(value);
    }
    @Override
    public void validate(ExecutionContext data, Object[] arguments) throws ArgumentException
    {
        if(arguments.length == ExceptionConsts.NO_ARGUMENTS_NUMBER)
        {
            throw new ArgumentException(operationName_,
                    ExceptionConsts.NO_ENOUGH_ARGUMENTS);
        }
        if(arguments.length > ExceptionConsts.PUSH_ARGUMENTS_NUMBER)
        {
            throw new ArgumentException(operationName_,
                    ExceptionConsts.TOO_MANY_ARGUMENTS);
        }
        return;
    }
}
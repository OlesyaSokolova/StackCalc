package operationDescripton;

import data.ExecutionContext;
import exceptions.*;
import consts.*;
public class Sqrt extends Operation
{
    public Sqrt(String opName)
    {
        super(opName);
    }
    @Override
    public void execution(ExecutionContext data, Object[] arguments) throws CalculatingException, ArgumentException
    {
        Object[] values = null;
        try
        {
            values = data.getTopElements(UsefulConsts.SQRT_ARGUMENTS_NUMBER);
        }
        catch(java.lang.NumberFormatException formatEx)
        {
            throw new ArgumentException(operationName_,
                    formatEx.getMessage() + UsefulConsts.LINE_DELIMITER + ExceptionConsts.UNDEFINED_VALUE);
        }
        if(values == null)
        {
            throw new ArgumentException(operationName_,
                    ExceptionConsts.NO_ENOUGH_ARGUMENTS);
        }
        Double value = null;
        try
        {
            value = (Double)values[UsefulConsts.FIRST_ARGUMENT_INDEX];
        }
        catch(java.lang.NumberFormatException formatEx)
        {
            throw formatEx;
        }
        if(value < 0)
        {
            throw new CalculatingException(operationName_,
                    ExceptionConsts.INACCEPTABLE_ARGUMENT + UsefulConsts.PHRASE_DELIMITER+ ExceptionConsts.NEGATIVE_NUMBER,
                    value);
        }
        Double valueSqrt = Math.sqrt((Double)values[UsefulConsts.FIRST_ARGUMENT_INDEX]);
        data.push(valueSqrt);
    }

}
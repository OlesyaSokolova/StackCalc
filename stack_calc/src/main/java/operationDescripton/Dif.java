package operationDescripton;

import data.ExecutionContext;
import exceptions.ArgumentException;
import exceptions.CalculatingException;
import consts.*;
public class Dif extends Operation
{
    public Dif(String opName)
    {
        super(opName);
    }

    @Override
    public void execution(ExecutionContext data, Object[] arguments) throws CalculatingException, ArgumentException
    {
        Object[] values = null;
        try
        {
            values = data.getTopElements(UsefulConsts.DIF_ARGUMENTS_NUMBER);
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
        Double result = (double)values[UsefulConsts.MINUEND_INDEX] - (double)values[UsefulConsts.SUBTRAHEND_INDEX];
        data.push(result);
    }
}
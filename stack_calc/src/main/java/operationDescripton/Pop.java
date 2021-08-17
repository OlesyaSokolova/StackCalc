package operationDescripton;

import data.*;
import exceptions.ArgumentException;
import exceptions.CalculatingException;

import java.lang.Object;


public class Pop extends Operation
{
    public Pop(String opName)
    {
        super(opName);
    }

    @Override
    public void execution(ExecutionContext data, Object[] arguments) throws CalculatingException, ArgumentException
    {
        Object value =  data.pop();
    }
}
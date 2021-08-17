package operationDescripton;
import data.*;
import exceptions.ArgumentException;
import exceptions.CalculatingException;
import consts.*;
public abstract class Operation implements Cloneable
{
    Operation(String operationName)
    {
        operationName_ =  operationName;
    }
    public Operation clone() throws CloneNotSupportedException
    {
        return (Operation)super.clone();
    }
    abstract public void execution(ExecutionContext data, Object[] arguments) throws CalculatingException, ArgumentException;

    public void validate(ExecutionContext data, Object[] arguments) throws ArgumentException
    {
        if(arguments.length != ExceptionConsts.NO_ARGUMENTS_NUMBER)
        {
            throw new ArgumentException(operationName_,
                    ExceptionConsts.TOO_MANY_ARGUMENTS);
        }
    }

    public String getOperationName_() {
        return operationName_;
    }

    protected String operationName_;
}



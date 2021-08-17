package logic;
import consts.OperationsNames;
import exceptions.CommandException;
import consts.ExceptionConsts;
import operationDescripton.*;

import java.lang.*;

import java.util.HashMap;
import java.util.Map;

public class OperationsFactory
{
    public OperationsFactory()
    {
        objectsMap_ = new HashMap<String, Object>();
        objectsMap_.put(OperationsNames.DEFINE, new Define(OperationsNames.DEFINE));
        objectsMap_.put(OperationsNames.PUSH, new Push(OperationsNames.PUSH));
        objectsMap_.put(OperationsNames.POP, new Pop(OperationsNames.POP));
        objectsMap_.put(OperationsNames.ADD, new Add(OperationsNames.ADD));
        objectsMap_.put(OperationsNames.DIF, new Dif(OperationsNames.DIF));
        objectsMap_.put(OperationsNames.MUL, new Mul(OperationsNames.MUL));
        objectsMap_.put(OperationsNames.DIV, new Div(OperationsNames.DIV));
        objectsMap_.put(OperationsNames.PRINT, new Print(OperationsNames.PRINT));
        objectsMap_.put(OperationsNames.SQRT, new Sqrt(OperationsNames.SQRT));
    };
    public Operation createOp(String opName) throws CommandException
    {
        Operation result = null;
        result = (Operation)objectsMap_.get(opName);
        Operation clone = null;
        try
        {
            clone = result.clone();
        }
        catch(java.lang.NullPointerException ex)
        {
            throw new CommandException(opName, ExceptionConsts.UNKNOWN_OPERATION);
        }
        catch(CloneNotSupportedException ex)
        {
            throw new CommandException(opName, ExceptionConsts.UNKNOWN_OPERATION);
        }
        return clone;
    }
    private Map<String, Object>objectsMap_;
}

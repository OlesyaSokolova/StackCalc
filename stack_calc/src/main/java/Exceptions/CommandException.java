package exceptions;

import consts.ExceptionConsts;

public class CommandException extends StackCalcException
{
    public CommandException(String problemObjectName, String currentProblem)
    {
        super(problemObjectName, ExceptionConsts.BAD_OPERATION, currentProblem);
    }
}

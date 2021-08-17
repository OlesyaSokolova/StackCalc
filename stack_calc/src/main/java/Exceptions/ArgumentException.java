package exceptions;
import consts.*;

public class ArgumentException extends StackCalcException
{
    public ArgumentException(String problemObjectName, String currentProblem)
    {
        super(problemObjectName, ExceptionConsts.PROBLEM_WITH_ARGUMENT, currentProblem);
    }
}

package exceptions;

import consts.*;

public class CalculatingException extends ArgumentException
{
    public CalculatingException(String problemObjectName, String currentProblem, Object arguments)
    {
        super(problemObjectName, currentProblem);
        badArgumentsAsString_ = arguments.toString();
    }
    public void showArguments()
    {
        System.out.println((ExceptionConsts.SHOW_ARGUMENT + badArgumentsAsString_));
    }
    private String badArgumentsAsString_;
}

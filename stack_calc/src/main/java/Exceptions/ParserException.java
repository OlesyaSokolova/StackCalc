package exceptions;

import consts.ExceptionConsts;

public class ParserException extends  StackCalcException
{
    public ParserException(String problemObjectName, String currentProblem)
    {
        super(problemObjectName, ExceptionConsts.BAD_PARSER, currentProblem);
    }
}

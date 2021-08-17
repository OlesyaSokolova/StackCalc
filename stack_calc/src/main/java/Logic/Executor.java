package logic;
import data.ExecutionContext;
import data.ExecutionContextImpl;
import consts.UsefulConsts;
import operationDescripton.*;
import java.util.*;
import java.util.ArrayList;
import exceptions.*;
public class Executor
{
    private ArrayList<String[]> commandsWithArguments_;
    private OperationsFactory currentCreator_;
    private ExecutionContext context_;
    private Object[] operationResult_;
    public Executor(ArrayList<String[]> commandsWithArguments, OperationsFactory creator)
    {
         commandsWithArguments_= commandsWithArguments;
         currentCreator_ = creator;
         context_ = new ExecutionContextImpl();
    }
    public void start(){
        Operation operation = null;
        String commandName = null;
        Object[] commandArguments = null;
        for(String[] commandWithArgument: commandsWithArguments_)
        {
            if(commandWithArgument.length == UsefulConsts.ONE_ARGUMENT && commandWithArgument[UsefulConsts.FIRST_ARGUMENT_INDEX].equals((UsefulConsts.EMPTY_STRING)))
            {
                continue;
            }
           commandName = commandWithArgument[UsefulConsts.VALUE_NAME_INDEX];
           commandArguments =  Arrays.copyOfRange(commandWithArgument, UsefulConsts.FIRST_VALUE_INDEX, commandWithArgument.length);
           try
           {
               operation = currentCreator_.createOp(commandName);
           }
           catch (CommandException ex)
           {
               ex.whatIsTheProblem();
               continue;
           }
            try
            {
                operation.validate(context_, commandArguments);
            }
           catch(ArgumentException ex)
           {
               ex.whatIsTheProblem();
               continue;
           }
           try
           {
               operation.execution(context_, commandArguments);
           }
           catch(CalculatingException ex)
           {
               ex.whatIsTheProblem();
               continue;
           }
           catch(ArgumentException ex)
           {
               ex.whatIsTheProblem();
               continue;
           }
        }
    }

    public Object getResult() {
        return context_.peek();
    }
}

import java.io.*;

import consts.*;
import exceptions.ParserException;
import logic.*;
import javafx.util.Pair;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Pair<String, ParsersTypes> parserDescriptin = determiningParser(args);
        ParsersFactory pFactory = new ParsersFactory();
        CommandsParser parser = null;
        try{
            parser = pFactory.createParser(parserDescriptin.getValue());
        }
        catch(ParserException e)
        {
            String problemDescription = ExceptionConsts.BAD_PARSER + parserDescriptin.getKey().toString()
                    + UsefulConsts.LINE_DELIMITER + ExceptionConsts.MAIN_BREAK
                    + UsefulConsts.LINE_DELIMITER + ExceptionConsts.EXCEPTION_MESSAGE_DELIMITER;
            System.out.println(problemDescription);
            return;
        }
        parser.parsingCommandDescriptions(parserDescriptin.getKey());
        OperationsFactory creator = new OperationsFactory();
        Executor executor = new Executor(parser.getCommandsAndArguments_(), creator);
        executor.start();
        return;
    }
    private static Pair<String, ParsersTypes> determiningParser(String[] args)
    {
        String source = UsefulConsts.CONSOLE_INPUT;
        ParsersTypes type = ParsersTypes.CONSOLE_PARSER;
        if(args.length == UsefulConsts.REQURED_ARGUMENTS_NUMBER)
        {
            if(args[UsefulConsts.FILE_INDEX].endsWith(UsefulConsts.FILE_FORMAT))
            {
                source = args[UsefulConsts.FILE_INDEX];
                type = ParsersTypes.FILE_PARSER;
            }
        }
        return new Pair<>(source, type);
    }
}
package logic;
import consts.ExceptionConsts;
import consts.UsefulConsts;
import exceptions.ParserException;

import java.lang.*;

import java.util.HashMap;
import java.util.Map;

public class ParsersFactory
{
    public ParsersFactory()
    {
        objectsMap_ = new HashMap<consts.ParsersTypes, Object>();
        objectsMap_.put(consts.ParsersTypes.FILE_PARSER, new FileParser());
        objectsMap_.put(consts.ParsersTypes.CONSOLE_PARSER, new ConsoleParser());
    };
    public CommandsParser createParser(consts.ParsersTypes parserType) throws ParserException
    {
        CommandsParser parser = null;
        parser = (CommandsParser)objectsMap_.get(parserType);
        CommandsParser clone = null;
        try
        {
            clone = parser.clone();
        }
        catch(CloneNotSupportedException e)
        {
           throw new ParserException(parserType.toString(), ExceptionConsts.UNKNOWN_PARSER
                   + UsefulConsts.LINE_DELIMITER + ExceptionConsts.MAIN_BREAK);
        }
        return clone;
    }
    private Map<consts.ParsersTypes, Object>objectsMap_;
}

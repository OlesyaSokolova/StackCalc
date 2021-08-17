package logic;

import consts.ParsersTypes;
import consts.UsefulConsts;

import java.io.IOException;
import java.util.ArrayList;

public abstract class CommandsParser implements Cloneable
{
    public CommandsParser(ParsersTypes type)
    {
        type_ = type;
        commandsAndArguments_ = new ArrayList<String[]>();
    };
    public CommandsParser clone() throws CloneNotSupportedException
    {
        return (CommandsParser)super.clone();
    }
    protected ArrayList<String[]> commandsAndArguments_;

    public ArrayList<String[]> getCommandsAndArguments_()
    {
        return commandsAndArguments_;
    }
    protected String[] parseCommand(String command)
    {
        String[] result = null;
        String delimiter = UsefulConsts.COMMAND_DESCRIPTION_DELIMITER;
        result = command.split(delimiter);
        return result;
    }

    public ParsersTypes getParserType() {
        return type_;
    }

    private ParsersTypes type_ = null;
    abstract public void parsingCommandDescriptions(String commandsSource) throws IOException;

    public void addCommand(String[] commandWithArguments)
    {
        this.commandsAndArguments_.add(commandWithArguments);
    }
}

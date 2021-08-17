package logic;
import consts.ParsersTypes;

import java.io.*;
import java.util.*;

public class FileParser extends CommandsParser
{
    public FileParser() {super(ParsersTypes.FILE_PARSER); };
    private String fileName_;

    @Override
    public void parsingCommandDescriptions(String source) throws IOException
    {
        fileName_ = source;
        FileReader reader = new FileReader(fileName_);
        String newString;
        ArrayList<String>commands = new ArrayList<String>();
        Scanner readScan = new Scanner(reader);
        while((readScan.hasNextLine()))
        {
            newString = readScan.nextLine();
            commands.add(newString);
        }
        int i;
        for(String command: commands)
        {
            String[] commandWithArguments = super.parseCommand(command);
            commandsAndArguments_.add(commandWithArguments);
        }
    }
}

package logic;

import consts.ParsersTypes;
import consts.UsefulConsts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleParser extends CommandsParser
{
    public ConsoleParser() {super(ParsersTypes.CONSOLE_PARSER);};

    @Override
    public void parsingCommandDescriptions(String commandsSource) throws IOException
    {
          // FileReader reader = new FileReader(fileName_);
        Scanner consoleScanner = new Scanner(System.in);

        ArrayList<String> commands = new ArrayList<String>();
        System.out.println("Enter commands to execute:");
        String newString = consoleScanner.nextLine();
        while(!(newString.equals(UsefulConsts.DESCRIPTION_END)))
        {
            commands.add(newString);
            newString = consoleScanner.nextLine();

        }
        int i;
        for(String command: commands)
        {
            String[] commandWithArguments = super.parseCommand(command);
            commandsAndArguments_.add(commandWithArguments);
        }
    }

}

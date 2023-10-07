package yurij.study.repeater;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * Get user input class
 */
public class ConsoleInput {
    private final String repeatCommand = "REPEAT";
    private final String reverseCommand = "REVERSE";
    private final List<TextProcessor> processorsList = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);

    /**
     * Read user input method
     * @return InputResult object
     */
    public InputResult read() {

        System.out.print("Enter your string: ");
        String inputString = in.nextLine();

        System.out.print("How many commands you want use: ");
        int commandsCount = in.nextInt();

        tryAddProcessor(commandsCount);

        in.close();

        return new InputResult(inputString, processorsList);
    }

    /**
     * Try read user processor input and add to list
     * @param commandsCount - how match commands user want to use
     */
    private void tryAddProcessor(int commandsCount) {
        for (int i = commandsCount; i > 0; i--){
            TextProcessor processor = null;

            while(processor == null) {
                String userCommand = in.nextLine();

                processor = tryParseCommand(userCommand);
            }

            processorsList.add(processor);
        }
    }

    /**
     * User commands parser method
     * @param userCommand - user input
     * @return - new TextProcessor object if command successful parsed
     */
    private TextProcessor tryParseCommand(String userCommand) {
        switch (userCommand){
            case repeatCommand:
                System.out.print("Repeat count: ");
                int repeatCount = in.nextInt();
                System.out.printf("Command: REPEAT, should repeat: %d times \n", repeatCount);

                return new RepeatText(repeatCount);

            case reverseCommand:
                System.out.print("Command: REVERSE\n");

                return  new ReverseText();

            default:
                System.out.print("Available commands - REPEAT, REVERSE \n");
                System.out.print("Enter command: ");

                return null;
        }
    }
}

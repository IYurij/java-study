package yurij.study.repeater;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Get commands from file
 */
public class FileInput {
    private static final String repeatCommand = "REPEAT";
    private static final String reverseCommand = "REVERSE";
    private static final String path = "D:/my-study/java/java-study/src/yurij/study/repeater/";
    private final String fileName;

    public FileInput(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Read commands from file method
     * @return InputResult object
     */
    public InputResult read() {
        String inputString;

        List<String> stringsList = createStringsList(fileName);

        inputString = stringsList.get(0);

        List<TextProcessor> processorsList = createTextProcessorsList(stringsList);

        return new InputResult(inputString, processorsList);
    }

    /**
     * Method read commands from file and return TextProcessors list
     * @param stringsList - full strings from file as list
     * @return TextProcessors list
     */
    private List<TextProcessor> createTextProcessorsList(List<String> stringsList) {
        List<TextProcessor> processorsList = new ArrayList<>();

        List<String> commandsSubList = stringsList.subList(2, stringsList.size());

        for (String s : commandsSubList) {
            String[] command = s.split(" ");

            if (command.length > 1 && Objects.equals(command[0], repeatCommand)) {
                processorsList.add(new RepeatText(Integer.parseInt(command[1])));
            } else if (Objects.equals(command[0], reverseCommand)) {
                processorsList.add(new ReverseText());
            } else {
                throw new RuntimeException("Command not found");
            }
        }

        return processorsList;
    }

    /**
     * Read all strings from file to List
     * @param fileName file name with strings
     * @return strings as List make from file
     */
    private List<String> createStringsList(String fileName) {
        List<String> commandsList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path + fileName))) {
            String s;

            while((s = br.readLine()) != null) {
                commandsList.add(s);
                System.out.println(s);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

        return commandsList;
    }
}

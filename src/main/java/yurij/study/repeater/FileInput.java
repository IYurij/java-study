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
public class FileInput implements Readable {
    private static final String repeatCommand = "REPEAT";
    private static final String reverseCommand = "REVERSE";
    private static final String path = "src/main/resources/";
    private final String fileName;

    public FileInput(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Read commands from file method
     *
     * @return InputResult object
     */
    public InputResult read() {
        InputData inputData = tryReadTextFile();

        List<TextProcessor> processorsList = createTextProcessorsList(inputData.getCommandsList());

        return new InputResult(inputData.getText(), processorsList);
    }

    /**
     * Method for create textProcessors list
     *
     * @param commandsList - list of Command objects
     * @return List<TextProcessor> - text processors list
     */
    private List<TextProcessor> createTextProcessorsList(List<Command> commandsList) {
        List<TextProcessor> processorsList = new ArrayList<>();

        for (Command command : commandsList) {

            if (Objects.equals(command.getName(), repeatCommand)) {
                processorsList.add(new RepeatText(command.getCount()));
            } else if (Objects.equals(command.getName(), reverseCommand)) {
                processorsList.add(new ReverseText());
            } else {
                throw new RuntimeException("Command not found");
            }
        }

        return processorsList;
    }

    /**
     * Method for create InputData object from json file
     *
     * @return InputData object
     */
    private InputData tryReadTextFile() {
        InputData inputData = new InputData();

        try (BufferedReader br = new BufferedReader(new FileReader(path + fileName))) {
            String s;
            int linesCount = 0;

            while ((s = br.readLine()) != null) {
                if (linesCount == 0) {
                    inputData.setText(s);
                } else {
                    var splitCommand = s.split(" ");

                    if (splitCommand.length > 1) {
                        inputData.addCommandToCommandsList(splitCommand[0], Integer.parseInt(splitCommand[1]));
                    } else {
                        inputData.addCommandToCommandsList(splitCommand[0]);
                    }
                }

                System.out.println(s);
                linesCount++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }


        return inputData;
    }
}

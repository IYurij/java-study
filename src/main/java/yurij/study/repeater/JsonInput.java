package yurij.study.repeater;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Get commands from json file
 */
public class JsonInput implements Readable {
    private static final String repeatCommand = "REPEAT";
    private static final String reverseCommand = "REVERSE";
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String fileName;

    public JsonInput(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Read commands from json file method
     *
     * @return InputResult object
     */
    public InputResult read() {
        InputData inputData = tryReadJson();

        assert inputData != null;
        List<TextProcessor> processors = createTextProcessorsList(inputData.getCommandsList());

        return new InputResult(inputData.getText(), processors);
    }

    /**
     * Method read commands from file and return TextProcessors list
     *
     * @param commandsList commands list from InputData object
     * @return TextProcessors list
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
     * Try read json file
     *
     * @return InputData object if success or empty InputData object
     */
    private InputData tryReadJson() {
        URL url = JsonInput.class.getClassLoader().getResource(fileName);

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        InputData inputData;
        try {
            assert url != null;
            inputData = objectMapper.readValue(new File(url.getFile()), InputData.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

            return InputData.empty();
        }

        return inputData;
    }
}

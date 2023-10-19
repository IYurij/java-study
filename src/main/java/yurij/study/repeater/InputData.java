package yurij.study.repeater;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO object for commands
 */
public class InputData {
    private String text;
    private List<Command> commandsList = new ArrayList<>();

    public InputData() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Command> getCommandsList() {
        return commandsList;
    }

    public void setCommandsList(List<Command> commandsList) {
        this.commandsList = commandsList;
    }

    public static InputData empty() {
        return new InputData();
    }

    /**
     * Method for add new Command object to the InputData object
     *
     * @param name text string
     */
    public void addCommandToCommandsList(String name) {
        Command command = new Command();
        command.setName(name);
        commandsList.add(command);
    }

    /**
     * Method for add new Command object to the InputData object
     *
     * @param name  text string
     * @param count repeat count
     */
    public void addCommandToCommandsList(String name, Integer count) {
        Command command = new Command();
        command.setName(name);
        command.setCount(count);
        commandsList.add(command);
    }
}

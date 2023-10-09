package yurij.study.repeater;

import java.util.List;

/**
 * Class for user input result
 */
public class InputResult {
    private final String text;
    private final List<TextProcessor> processors;

    public InputResult(String text, List<TextProcessor> processors){
        this.text = text;
        this.processors = processors;
    }

    public String getText() {
        return text;
    }

    public List<TextProcessor> getProcessors() {
        return processors;
    }
}

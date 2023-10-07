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

    /**
     * Run processors method
     */
    public void doProcessors() {
        for ( TextProcessor processor : processors) {
            String result = processor.process(text);

            System.out.printf("%s", result);
        }
    }
}

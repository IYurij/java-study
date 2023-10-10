package yurij.study.repeater;

import java.util.List;

/**
 * Class for create repeated text.
 * Main class for repeater-package.
 */
public class Main {
    /**
     * Program start point.
     * @param args - start program arguments.
     */
    public static void main(String[] args) {
        var consoleInput = new ConsoleInput();

        InputResult inputResult = consoleInput.read();

        doProcessors(inputResult.getText(), inputResult.getProcessors());
    }

    /**
     * Run processors method
     */
    private static void doProcessors(String text, List<TextProcessor> processors) {
        for (TextProcessor processor : processors) {
            String result = processor.process(text);

            System.out.println(result);
        }
    }
}
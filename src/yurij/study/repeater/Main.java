package yurij.study.repeater;

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

        inputResult.doProcessors();
    }
}
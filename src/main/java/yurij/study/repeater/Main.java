package yurij.study.repeater;

import java.util.List;
import java.util.Objects;

/**
 * Class for create repeated text.
 * Main class for repeater-package.
 */
public class Main {
    private static final String fileName = "input-data.dat";
    private static final String jsonName = "input-json.json";

    /**
     * Program start point.
     *
     * @param args - start program arguments.
     */
    public static void main(String[] args) {
        Readable inputData;

        if (args.length == 0 || (args.length == 1 && Objects.equals(args[0], "-console"))) {
            inputData = new ConsoleInput();
        } else if (args.length == 2 && Objects.equals(args[0], "-file")) {
            inputData = new FileInput(args[1]);
        } else if (args.length == 2 && Objects.equals(args[0], "-json")) {
            inputData = new JsonInput(args[1]);
        }else {
            throw new RuntimeException("Incorrect command!");
        }

        InputResult inputResult = inputData.read();

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
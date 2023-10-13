package yurij.study.repeater;

import java.util.List;

/**
 * Class for create repeated text.
 * Main class for repeater-package.
 */
public class Main {
    //+    у нас есть класс ConsoleInput, нужно будет его скопировать (пока что скопировать) в новый класс,
    //    и реализовать ввод через файл вместо System.in.
    //    Имя файла должно передаваться в конструктор класса FileInput.
    //    в Main классе потребуется заменить ConsoleInput на FileInput, имя файла пока забить константой.
    //    https://metanit.com/java/tutorial/6.1.php
    //    https://metanit.com/java/tutorial/6.8.php

    private static final String fileName = "input-data.dat";
    /**
     * Program start point.
     * @param args - start program arguments.
     */
    public static void main(String[] args) {
        var fileInput = new FileInput(fileName);

        InputResult inputResult = fileInput.read();

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
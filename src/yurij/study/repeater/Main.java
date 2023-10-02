package yurij.study.repeater;

import java.util.Scanner;

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

        InputData inputData = getUserData();

        String resultString = RepeatText.process(inputData.getText(), inputData.getRepeatCount());

        System.out.print(resultString);
    }

    /**
     * Method get user input and create InputData object.
     * @return new InputData object.
     */
    private static InputData getUserData() {
        Scanner in = new Scanner(System.in);

        System.out.print("Input string: ");
        String inputString = in.nextLine();

        System.out.print("Repeat count: ");
        int repeatCount = in.nextInt();

        in.close();

        System.out.printf("String: %s, should repeat: %d times \n", inputString, repeatCount);

        return new InputData(inputString, repeatCount);
    }
}
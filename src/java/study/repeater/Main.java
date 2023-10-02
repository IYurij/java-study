package java.study.repeater;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InputData inputData = getUserData();

        String resultString = buildMultyString(inputData);

        System.out.print(resultString);
    }

    /**
     * Method get user input and create java.study.repeater.InputData object
     * @return new java.study.repeater.InputData object
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

    /**
     * Method for build string with repeat
     * @param inputData - java.study.repeater.InputData object
     * @return repeated string
     */
    private static String buildMultyString(InputData inputData) {

        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < inputData.getRepeatCount(); i++) {
            resultString.append(inputData.getText()).append("\n");
        }

        return resultString.toString();
    }
}
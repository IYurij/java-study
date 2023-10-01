import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Input string: ");
        String inputString = in.nextLine();

        System.out.print("Repeat count: ");
        int repeatCount = in.nextInt();

        in.close();

        System.out.printf("String: %s, should repeat: %d times \n", inputString, repeatCount);
        String resultString = buildMultyString(inputString, repeatCount);

        System.out.print(resultString);
    }

    private static String buildMultyString(String inputString, int repeatCount) {

        StringBuilder resultString = new StringBuilder();

        for (int i = 0; i < repeatCount; i++) {
            resultString.append(inputString).append("\n");
        }

        return resultString.toString();
    }
}
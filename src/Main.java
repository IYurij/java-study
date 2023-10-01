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

        for (int i = 0; i < repeatCount; i++){
            System.out.print(inputString + "\n");
        }
    }
}
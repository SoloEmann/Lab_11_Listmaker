import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner console, String prompt) {
        String input;

        do {
            System.out.print(prompt + ": ");
            input = console.nextLine().trim();
        } while (input.isEmpty());

        return input;
    }

    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int value = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");

            if (console.hasNextInt()) {
                value = console.nextInt();

                if (value >= low && value <= high) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + low + " and " + high);
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
            }

            console.nextLine();

        } while (!valid);

        return value;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        String answer;

        do {
            System.out.print(prompt + " [Y/N]: ");
            answer = console.nextLine().trim().toUpperCase();

            if (!answer.equals("Y") && !answer.equals("N")) {
                System.out.println("Please enter Y or N.");
            }

        } while (!answer.equals("Y") && !answer.equals("N"));

        return answer.equals("Y");
    }

    public static String getRegExString(Scanner console, String prompt, String regEx) {
        String input;

        do {
            System.out.print(prompt + ": ");
            input = console.nextLine();

            if (!input.matches(regEx)) {
                System.out.println("Invalid input. Try again.");
            }

        } while (!input.matches(regEx));

        return input;
    }
}
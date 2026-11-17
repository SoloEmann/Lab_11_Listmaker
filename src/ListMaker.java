import java.util.Scanner;
import java.util.ArrayList;

public class ListMaker {

    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        boolean done = false;

        do {
            printList();

            System.out.println("\nA - Add");
            System.out.println("D - Delete");
            System.out.println("I - Insert");
            System.out.println("P - Print");
            System.out.println("Q - Quit");

            String choice = SafeInput.getRegExString(in,
                    "Enter your choice", "[AaDdIiPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    done = quit();
                    break;
            }

        } while (!done);

        System.out.println("Goodbye!");
    }

    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter item");
        list.add(item);
    }

    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            printList();

            int number = SafeInput.getRangedInt(in,
                    "Enter item number to delete", 1, list.size());

            list.remove(number - 1);
        }
    }

    private static void insertItem() {
        printList();

        int number = SafeInput.getRangedInt(in,
                "Enter position", 1, list.size() + 1);

        String item = SafeInput.getNonZeroLenString(in, "Enter item");

        list.add(number - 1, item);
    }

    private static void printList() {
        System.out.println("\nCurrent List:");

        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + " - " + list.get(i));
            }
        }
    }

    private static boolean quit() {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
    }
}
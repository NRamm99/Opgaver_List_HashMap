import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        opgave1();
    }

    // OPGAVE 1
    public static void opgave1() {
        ArrayList<String> fruits = new ArrayList<>();
        opgave1_promptMenu(fruits);

    }

    private static void opgave1_promptMenu(ArrayList<String> fruits) {
        opgave1_promptFruitAdder(fruits);
        boolean exit = false;
        while (!exit) {

            printToConsole("""
                    ---------- MENU ----------
                    1... Add fruits
                    2... Change fruits
                    3... Remove fruits
                    4... Show fruits
                    5... Exit
                    --------------------------
                    """);
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    opgave1_promptFruitAdder(fruits);
                    break;
                case 2:
                    opgave1_promptFruitChanger(fruits);
                    break;
                case 3:
                    opgave1_promptFruitRemover(fruits);
                    break;
                case 4:
                    opgave1_printFruits(fruits);
                    input.nextLine();
                    waitForUser();
                    break;
                case 5:
                    exit = true;
            }
        }

    }

    private static void opgave1_promptFruitRemover(ArrayList<String> fruits) {
        opgave1_printFruits(fruits);
        printToConsole("I want to remove fruit number:", false);
        int userInput = input.nextInt();
        fruits.remove((userInput - 1));
    }

    private static void opgave1_promptFruitChanger(ArrayList<String> fruits) {
        opgave1_printFruits(fruits);
        printToConsole("I want to change fruit number:", false);
        int userInput = input.nextInt();
        input.nextLine();
        printToConsole("Enter the new fruit:");
        String newFruit = input.nextLine();
        fruits.set((userInput - 1), newFruit);
    }

    private static void opgave1_printFruits(ArrayList<String> fruits) {
        printToConsole("List of fruits:");
        for (int n = 0; n < fruits.size(); n++) {
            System.out.println("#" + (n + 1) + ": " + fruits.get(n));
        }
        System.out.println("----------------");
    }

    public static void opgave1_promptFruitAdder(ArrayList<String> fruits) {
        printToConsole("How many fruits do you wish to add?");
        int fruitAmount = input.nextInt();
        input.nextLine();
        for (int n = 0; n < fruitAmount; n++) {
            System.out.print("Fruit #" + (n + 1) + ": ");
            fruits.add(input.nextLine());
        }
    }

    // VÆRKTØJER BRUGT GENERELT
    public static void clearConsole() {
        for (int n = 0; n < 20; n++) {
            System.out.println();
        }
    }

    public static void waitForUser() {
        System.out.println("Press enter to continue...");
        input.nextLine();
    }

    public static void printToConsole(String text, boolean clear) {
        if (clear) {
            clearConsole();
        }
        System.out.println(text);
    }

    public static void printToConsole(String text) {
        printToConsole(text, true);
    }

}
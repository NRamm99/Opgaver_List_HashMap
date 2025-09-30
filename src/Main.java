import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        printToConsole("""
                Vælg hvilken opgave du ønsker at køre:
                1... Opgave 1: Grundlæggende brug af ArrayList
                2... Opgave 2: Iteration og sortering
                3... Opgave 3: Filtrering af ArrayList
                4... Opgave 4: Grundlæggende brug af HashMap
                
                0... Luk program
                """);
        int userInput = input.nextInt();
        switch (userInput) {
            case 1:
                opgave1();
                break;
            case 2:
                opgave2();
                break;
            case 3:
                opgave3();
                break;
            case 4:
                opgave4();
                break;
            case 0:
                break;
        }
    }


    // Opgave 1: Grundlæggende brug af ArrayList

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


    // Opgave 2: Iteration og sortering

    private static void opgave2() {
        ArrayList<Integer> numbers = new ArrayList<>();
        opgave2_addNumbers(numbers);
        opgave2_printNumbers(numbers);
        input.nextLine();
        waitForUser();
        opgave2_sortNumbers(numbers);
        opgave2_printNumbers(numbers);
        input.nextLine();
        waitForUser();

    }

    private static void opgave2_sortNumbers(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
    }

    private static void opgave2_printNumbers(ArrayList<Integer> numbers) {
        printToConsole("List of numbers:");
        int counter = 1; // tæller starter ved 1
        for (int num : numbers) {
            System.out.println("#" + counter + ": " + num);
            counter++;
        }
        System.out.println("----------------");

    }

    private static void opgave2_addNumbers(ArrayList<Integer> numbers) {
        printToConsole("How many numbers do you wish to add?");
        int addAmount = input.nextInt();
        for (int n = 0; n < addAmount; n++) {
            System.out.print("#" + (n + 1) + ": ");
            numbers.add(input.nextInt());
        }
    }


    // Opgave 3: Filtrering af ArrayList
    private static void opgave3() {
        ArrayList<String> cities = new ArrayList<>();
        opgave3_cityAdder(cities);
        opgave3_printStartsWithA(cities);
    }

    private static void opgave3_printStartsWithA(ArrayList<String> cities) {
        printToConsole("Cities that start with an A:");
        for (String city : cities) {
            if (city.toLowerCase().startsWith("A".toLowerCase())) {
                System.out.println(city);
            }
        }
    }

    private static void opgave3_cityAdder(ArrayList<String> cities) {
        printToConsole("How many cities do you wish to add?");
        int addAmount = input.nextInt();
        input.nextLine();
        for (int n = 0; n < addAmount; n++) {
            System.out.print("#" + (n + 1) + ": ");
            cities.add(input.nextLine());
        }
    }

    // Opgave 4: Grundlæggende brug af HashMap

    private static void opgave4() {
        HashMap<String, Integer> people = new HashMap<>();
        opgave4_addPeople(people);
        opgave4_printPeople(people);
    }

    private static void opgave4_printPeople(HashMap<String, Integer> people) {
        clearConsole();
        for (HashMap.Entry<String, Integer> entry : people.entrySet()) {
            String name = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(name + " → " + age);
        }
    }

    private static void opgave4_addPeople(HashMap<String, Integer> people) {
        String name;
        int age;

        printToConsole("How many people do you wish to add?");
        int addAmount = input.nextInt();
        input.nextLine();
        for (int n = 0; n < addAmount; n++) {
            System.out.print("#" + (n + 1) + " navn: ");
            name = input.nextLine();
            System.out.print("#" + (n + 1) + " alder: ");
            age = input.nextInt();
            input.nextLine();
            people.put(name, age);
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
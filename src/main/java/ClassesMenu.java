import java.sql.Connection;
import java.util.Scanner;

public class ClassesMenu {

    public static void displayMenuClasses(Connection connection) {
        System.out.println("======= MENU CLASSES =======");
        System.out.println("1. Display table Classes");
        System.out.println("2. Add new class from keyboard");
        System.out.println("3. Add new class");
        System.out.println("4. Search for class");
        System.out.println("5. Delete class");
        System.out.println();
        System.out.println("Please select an option:");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                ClassesMenuHandler.displayTableClasses(connection);
                break;

            case "2":
                System.out.println("Please type class");
                String classe = scanner.nextLine();
                ClassesMenuHandler.insertClassesFromKeyboard(connection, classe);
                break;

            case "3":
                ClassesMenuHandler.insertNewClasses(connection);
                break;

            case "4":
                System.out.println("Please type the class");
                String className = scanner.nextLine();
                ClassesMenuHandler.searchForClass(connection, className);
                break;

            case "5":
                System.out.println("Please type the class");
                String classNameToDelete = scanner.nextLine();
                ClassesMenuHandler.deleteClass(connection, classNameToDelete);
                break;

            default:
                System.out.println("You did not select a valid option!");
                break;
        }
    }
}

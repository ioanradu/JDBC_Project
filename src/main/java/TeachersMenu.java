import java.sql.Connection;
import java.util.Scanner;

public class TeachersMenu {

    public static void displayMenuTeacher(Connection connection) {
        System.out.println("======= MENU TEACHERS =======");
        System.out.println("1. Display table Teachers");
        System.out.println("2. Add new teacher from keyboard");
        System.out.println("3. Add new teacher");
        System.out.println("4. Search for teacher");
        System.out.println("5. Delete teacher");
        System.out.println();
        System.out.println("Please select an option:");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                TeachersMenuHandler.displayTableTeachers(connection);
                break;

            case "2":
                System.out.println("Please type the first name of teacher");
                String firstNameOfTeacher = scanner.nextLine();
                System.out.println("Please type the last name of teacher");
                String lastNameOfTeacher = scanner.nextLine();
                System.out.println("Please type the type of teacher");
                String typeOfTeacher = scanner.nextLine();
                System.out.println("Please type the age of teacher");
                int ageOfTeacher = scanner.nextInt();

                TeachersMenuHandler.insertTeachersFromKeyboard(connection, firstNameOfTeacher, lastNameOfTeacher, ageOfTeacher, typeOfTeacher);
                break;

            case "3":
                TeachersMenuHandler.insertNewTeachers(connection);
                break;

            case "4":
                System.out.println("Please type the first name of teacher");
                firstNameOfTeacher = scanner.nextLine();
                /*System.out.println("Please type the last name of teacher");
                lastNameOfTeacher = scanner.nextLine();*/

                TeachersMenuHandler.searchForTeacher(connection, firstNameOfTeacher);
                break;

            case "5":
                System.out.println("Please type the first name of the teacher");
                String firstNameOfTheTeacher = scanner.nextLine();
                System.out.println("Please type the last name of the teacher");
                String lastNameOfTheTeacher = scanner.nextLine();
                TeachersMenuHandler.deleteTeacher(connection, firstNameOfTheTeacher, lastNameOfTheTeacher);

            default:
                System.out.println("You did not select a valid option!");
                break;
        }
    }
}

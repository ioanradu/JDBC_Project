import java.sql.Connection;
import java.util.Scanner;

public class StudentsMenu {

    public static void displayMenuStudents(Connection connection) {
        System.out.println("======= MENU STUDENTS =======");
        System.out.println("1. Display table Students");
        System.out.println("2. Add new student from keyboard");
        System.out.println("3. Add new student");
        System.out.println("4. Search for student");
        System.out.println("5. Delete student");
        System.out.println();
        System.out.println("Please select an option:");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                StudentsMenuHandler.displayTableStudents(connection);
                break;

            case "2":
                System.out.println("Please type the first name of student");
                String firstNameOfStudent = scanner.nextLine();

                System.out.println("Please type the last name of student");
                String lastNameOfStudent = scanner.nextLine();

                System.out.println("Please type the age of student");
                int ageOfStudent = scanner.nextInt();

                StudentsMenuHandler.insertStudentsFromKeyboard(connection, firstNameOfStudent, lastNameOfStudent, ageOfStudent);
                break;

            case "3":
                StudentsMenuHandler.insertNewStudents(connection);
                break;

            case "4":
                System.out.println("Please type the first name of student");
                firstNameOfStudent = scanner.nextLine();
                System.out.println("Please type the last name of student");
                lastNameOfStudent = scanner.nextLine();

                StudentsMenuHandler.searchForStudent(connection, firstNameOfStudent, lastNameOfStudent);
                break;

            case "5":
                System.out.println("Please type the first name of the student");
                String firstNameOfTheStudent = scanner.nextLine();
                System.out.println("Please type the last name of the student");
                String lastNameOfTheStudent = scanner.nextLine();
                StudentsMenuHandler.deleteStudent(connection, firstNameOfTheStudent, lastNameOfTheStudent);

            default:
                System.out.println("You did not select a valid option!");
                break;
        }
    }
}



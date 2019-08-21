import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "parola");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("=============== MENU ================");
        System.out.println("1. Search / Insert / Delete Students");
        System.out.println("2. Search / Insert / Delete Teachers");
        System.out.println("3. Search / Insert / Delete Classes");
        System.out.println();
        System.out.println("Please select an option:");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                StudentsMenu.displayMenuStudents(connection);
                break;
            case 2:
                TeachersMenu.displayMenuTeacher(connection);
                break;
            case 3:
                ClassesMenu.displayMenuClasses(connection);
                break;
            default:
                System.out.println("You did not select a valid option!");
                break;
        }
    }
}

import java.sql.*;

public class StudentsMenuHandler {

    public static void displayTableStudents(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                System.out.println("Studentul cu id-ul: " + id + " este " + firstName + " " + lastName + " si are varsta " + age + " ani.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertStudentsFromKeyboard(Connection connection, String firstName, String lastName, int ageOfStudents) {
        String sql = "INSERT INTO students(first_name, last_name, age) values(?, ?, ?)";
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, ageOfStudents);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result == 1) {
            System.out.println("Studentul a fost inserat cu succes!");
        } else {
            System.out.println("Studentul nu s-a inserat!");
        }
    }

    public static void searchForStudent(Connection connection, String firstName, String lastName) {

        String sql = "SELECT * FROM students WHERE first_name = ? AND last_name = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {

                String firstNameToDisplay = resultSet.getString("first_name");
                String lastnameToDisplay = resultSet.getString("last_name");
                int ageToDisplay = resultSet.getInt("age");

                /*String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");*/
                System.out.println("Studentul " + firstNameToDisplay + " " + lastnameToDisplay + " are varsta " + ageToDisplay + " ani.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewStudents(Connection connection) {
        Statement stmt = null;
        int result = 0;
        try {
            stmt = connection.createStatement();
            result = stmt.executeUpdate("INSERT INTO students(first_name, last_name, age) VALUES(\"Dorin\", \"Maftei\", 32)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("S-a inserat cu succes");
        } else {
            System.out.println("Nu s-a inserat cu succes!");
        }
    }

    public static void deleteStudent(Connection connection, String firstNameOfTheStudentToDelete, String lastNameOfTheStudentToDelete) {
        String sql = "DELETE FROM students WHERE first_name = ? AND last_name = ?";
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstNameOfTheStudentToDelete);
            stmt.setString(2, lastNameOfTheStudentToDelete);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result == 1) {
            System.out.println("Studentul a fost sters din tabelul students!");
        } else {
            System.out.println("Studentul nu a fost sters din tabelul students!");
        }
    }
}

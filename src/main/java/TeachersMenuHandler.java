import com.sun.source.tree.ClassTree;

import java.sql.*;

public class TeachersMenuHandler {

    public static void displayTableTeachers(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM teachers");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String type = resultSet.getString("type_teacher");
                System.out.println("Profesorul cu id-ul: " + id + " este " + firstName + " " + lastName +
                        " are varsta " + age + " si preda disciplina " + type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertTeachersFromKeyboard(Connection connection, String firstNameOfTeacher, String lastNameOfTeacher, int ageOfTeacher, String typeOfTeacher) {

        String sql = "INSERT INTO teachers(first_name, last_name, age, type_teacher) values(?, ?, ?, ?)";
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstNameOfTeacher);
            stmt.setString(2, lastNameOfTeacher);
            stmt.setInt(3, ageOfTeacher);
            stmt.setString(4, typeOfTeacher);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result == 1) {
            System.out.println("S-a inserat cu succes");
        } else {
            System.out.println("Nu s-a inserat cu succes!");
        }
    }

    public static void insertNewTeachers(Connection connection) {
        Statement stmt = null;
        int result = 0;
        try {
            stmt = connection.createStatement();
            result = stmt.executeUpdate("INSERT INTO teachers(first_name, last_name, age, type_teacher) VALUES(\"Vasile\", \"Dosoftei\", 30, \"Matematica\")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("S-a inserat cu succes");
        } else {
            System.out.println("Nu s-a inserat cu succes!");
        }
    }

    public static void searchForTeacher(Connection connection, String firstNameOfTeacher, String lastNameOfTeacher) {
        String sql = "SELECT * FROM teachers WHERE first_name = ? AND last_name = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstNameOfTeacher);
            stmt.setString(2, lastNameOfTeacher);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {

                String firstNameToDisplay = resultSet.getString("first_name");
                String lastnameToDisplay = resultSet.getString("last_name");
                int ageToDisplay = resultSet.getInt("age");
                String typeToDisplay = resultSet.getString("type_teacher");

                System.out.println("Profesorul " + firstNameToDisplay + " " + lastnameToDisplay + " are varsta " + ageToDisplay + " si preda disciplina " + typeToDisplay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTeacher(Connection connection, String firstNameOfTeacherToDelete, String lastNameOfTeacherToDelete) {
        String sql = "DELETE FROM teachers WHERE first_name = ? AND last_name = ?";
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, firstNameOfTeacherToDelete);
            stmt.setString(2, lastNameOfTeacherToDelete);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result == 1) {
            System.out.println("Profesorul a fost sters din tabelul teachers!");
        } else {
            System.out.println("Profesorul nu a fost sters din tabelul teachers!");
        }
    }
}

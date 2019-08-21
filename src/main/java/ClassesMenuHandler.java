import java.sql.*;

public class ClassesMenuHandler {

    public static void displayTableClasses(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM classes");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("Clasa " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertClassesFromKeyboard(Connection connection, String classe) {
        String sql = "INSERT INTO classes(name) values(?)";
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, classe);
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

    public static void insertNewClasses(Connection connection) {
        Statement stmt = null;
        int result = 0;
        try {
            stmt = connection.createStatement();
            result = stmt.executeUpdate("INSERT INTO classes(name) VALUES(\"X E\")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("S-a inserat cu succes");
        } else {
            System.out.println("Nu s-a inserat cu succes!");
        }
    }

    public static void searchForClass(Connection connection, String className) {
        String sql = "SELECT name FROM classes WHERE name = ?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, className);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String classToDisplay = resultSet.getString("name");
                System.out.println("Clasa " + classToDisplay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteClass(Connection connection, String classNameToDelete) {
        String sql = "DELETE FROM classes WHERE name = ?";
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, classNameToDelete);
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result == 1) {
            System.out.println("Clasa a fost stearsa din tabelul classes!");
        } else {
            System.out.println("Clasa nu a fost stearsa din tabelul classes!");
        }
    }
}

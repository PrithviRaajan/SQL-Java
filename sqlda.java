import java.sql.*;
import java.util.Scanner;

public class sqlda {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@ZENBOOK:1521:xe";
        String user = "system";
        String password = "4807";

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter SQL query (or 'exit' to quit): ");
                String query = scanner.nextLine();
                
                if (query.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting program.");
                    break;
                }
                
                if (query.trim().toLowerCase().startsWith("select")) {
                    executeQuery(url, user, password, query);
                } else {
                    executeUpdate(url, user, password, query);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void executeQuery(String url, String user, String password, String query) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            printLine(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(String.format("| %-20s", metaData.getColumnName(i)));
            }
            System.out.println("|");
            printLine(columnCount);

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(String.format("| %-20s", resultSet.getString(i)));
                }

                System.out.println("|");
            }
            printLine(columnCount);
            System.out.println();
        }
    }
    
    private static void executeUpdate(String url, String user, String password, String query) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(query);
            System.out.println("Query executed successfully. " + rowsAffected + " rows affected.");
        }
    }
    
    private static void printLine(int columnCount) {
        System.out.print("+");
        for (int i = 0; i < columnCount; i++) {
            System.out.print("----------------------+");
        }
        System.out.println();
    }
}
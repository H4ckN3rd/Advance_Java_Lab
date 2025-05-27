import java.sql.*;
import java.util.Scanner;

public class DatabaseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jatin";
        String user = "root";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected Successfully!");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "username VARCHAR(50) NOT NULL,"
                    + "password VARCHAR(50) NOT NULL"
                    + ")";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Table 'users' ensured!");
            }

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert User");
                System.out.println("2. Display Users");
                System.out.println("3. Update User Password");
                System.out.println("4. Delete User");
                System.out.println("5. Login");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String newUser = sc.nextLine();
                        System.out.print("Enter password: ");
                        String newPass = sc.nextLine();
                        String insertSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
                        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                            pstmt.setString(1, newUser);
                            pstmt.setString(2, newPass);
                            pstmt.executeUpdate();
                            System.out.println("User inserted successfully!");
                        }
                        break;

                    case 2:
                        String selectSQL = "SELECT * FROM users";
                        try (Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery(selectSQL)) {
                            System.out.println("Users:");
                            while (rs.next()) {
                                System.out.println("ID: " + rs.getInt("id") +
                                        ", Username: " + rs.getString("username") +
                                        ", Password: " + rs.getString("password"));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter username to update password: ");
                        String updateUser = sc.nextLine();
                        System.out.print("Enter new password: ");
                        String updatePass = sc.nextLine();
                        String updateSQL = "UPDATE users SET password = ? WHERE username = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                            pstmt.setString(1, updatePass);
                            pstmt.setString(2, updateUser);
                            int rows = pstmt.executeUpdate();
                            if (rows > 0) {
                                System.out.println("Password updated successfully!");
                            } else {
                                System.out.println("Username not found!");
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter username to delete: ");
                        String deleteUser = sc.nextLine();
                        String deleteSQL = "DELETE FROM users WHERE username = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                            pstmt.setString(1, deleteUser);
                            int rows = pstmt.executeUpdate();
                            if (rows > 0) {
                                System.out.println("User deleted successfully!");
                            } else {
                                System.out.println("Username not found!");
                            }
                        }
                        break;

                    case 5:
                        System.out.print("Enter username: ");
                        String loginUser = sc.nextLine();
                        System.out.print("Enter password: ");
                        String loginPass = sc.nextLine();
                        String loginSQL = "SELECT * FROM users WHERE username = ? AND password = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(loginSQL)) {
                            pstmt.setString(1, loginUser);
                            pstmt.setString(2, loginPass);
                            ResultSet rs = pstmt.executeQuery();
                            if (rs.next()) {
                                System.out.println("Login Successful! Welcome, " + loginUser);
                            } else {
                                System.out.println("Invalid credentials!");
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        conn.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Try again!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }
    }
}

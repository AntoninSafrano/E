import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private final String url = "jdbc:mysql://localhost:3306/easyline";
    private final String user = "root";
    private final String password = "root";
    private Connection connection;

    public LoginDAO() {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * @param username
     * @param password
     * @return boolean
     */
    public boolean checkLogin(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Retourne vrai si l'utilisateur existe dans la base de données
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

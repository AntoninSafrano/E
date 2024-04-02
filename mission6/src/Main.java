import java.sql.*;

public class Main {
    
    /** 
     * @param args
     */
    // Etape 1
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyline", "root", "root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM bagage;");

            System.out.println("Connected to database");

            System.out.println("ID\tNUMERO\t\tCOULEUR\t\tPOIDS\t\t");
            System.out.println("==============================================");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "\t" + resultSet.getString("weight") + "\t\t "
                        + resultSet.getString("color") + "\t\t" + resultSet.getString("weight") + "\t\t");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
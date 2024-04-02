import java.sql.*;

public class AdressePostaleDAO extends DAO<AdressePostale> {
    
    /** 
     * @return Connection
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyline", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    
    /** 
     * @param id
     * @return AdressePostale
     */
    public AdressePostale select(long id) {
        AdressePostale adressePostale = new AdressePostale("Rue", "Ville", 0);
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse_postale WHERE id=" + id);
            if (resultSet.next()) {
                adressePostale.setStreet(resultSet.getString("street"));
                adressePostale.setCity(resultSet.getString("city"));
                adressePostale.setPostalCode(resultSet.getInt("postal_code"));
                adressePostale.setId(resultSet.getLong("id"));
                return adressePostale;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    
    /** 
     * @param adressePostale
     * @return boolean
     */
    public boolean insert(AdressePostale adressePostale) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO adresse_postale (street, city, postal_code) VALUES (?, ?, ?)");
            preparedStatement.setString(1, adressePostale.getStreet());
            preparedStatement.setString(2, adressePostale.getCity());
            preparedStatement.setInt(3, adressePostale.getPostalCode());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    
    /** 
     * @param adressePostale
     * @return boolean
     */
    public boolean update(AdressePostale adressePostale) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE adresse_postale SET street=?, city=?, postal_code=? WHERE id=?");
            preparedStatement.setString(1, adressePostale.getStreet());
            preparedStatement.setString(2, adressePostale.getCity());
            preparedStatement.setInt(3, adressePostale.getPostalCode());
            preparedStatement.setLong(4, adressePostale.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean delete(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM adresse_postale WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}

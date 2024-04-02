import java.sql.*;

public class BagageDAO extends DAO<Bagage> {
    
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
     * @return Bagage
     */
    public Bagage select(long id) {
        Bagage bagage = new Bagage();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bagage WHERE id=" + id);
            if (resultSet.next()) {
                bagage.setNumber(resultSet.getInt("number"));
                bagage.setWeight(resultSet.getDouble("weight"));
                bagage.setColor(resultSet.getString("color"));
                bagage.setId(resultSet.getLong("id"));
                return bagage;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    
    /** 
     * @param bagage
     * @return boolean
     */
    public boolean insert(Bagage bagage) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO bagage (number, weight, color) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, bagage.getNumber());
            preparedStatement.setDouble(2, bagage.getWeight());
            preparedStatement.setString(3, bagage.getColor());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    
    /** 
     * @param bagage
     * @return boolean
     */
    public boolean update(Bagage bagage) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE bagage SET number=?, weight=?, color=? WHERE id=?");
            preparedStatement.setInt(1, bagage.getNumber());
            preparedStatement.setDouble(2, bagage.getWeight());
            preparedStatement.setString(3, bagage.getColor());
            preparedStatement.setLong(4, bagage.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM bagage WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        BagageDAO dao = new BagageDAO();
        Bagage bagage = new Bagage(12, 6, "rouge");

        // insertion d'un bagage
        dao.insert(bagage);

        // tests sur les bagages
        bagage = dao.select(7);
        System.out.println(bagage);

        bagage.setColor("violet");
        dao.update(bagage);

        System.out.println(dao.select(7));
    }
}

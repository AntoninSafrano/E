import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VoyageDAO {
    private final String url = "jdbc:mysql://localhost:3306/easyline";
    private final String user = "root";
    private final String password = "root";

    
    /** 
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    
    /** 
     * @param id
     * @return Voyage
     */
    public Voyage select(long id) {
        Voyage voyage = null;
        String query = "SELECT * FROM voyage WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String destination = resultSet.getString("destination");
                    LocalDate dateDepart = resultSet.getDate("date_depart").toLocalDate();
                    LocalDate dateRetour = resultSet.getDate("date_retour").toLocalDate();
                    String description = resultSet.getString("description");
                    voyage = new Voyage(destination, dateDepart, dateRetour, description);
                    voyage.setId(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyage;
    }


    
    /** 
     * @param voyage
     */
    public void insert(Voyage voyage) {
        String query = "INSERT INTO voyage (destination, date_depart, date_retour, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, voyage.getDestination());
            preparedStatement.setDate(2, java.sql.Date.valueOf(voyage.getDateDepart()));
            preparedStatement.setDate(3, java.sql.Date.valueOf(voyage.getDateRetour()));
            preparedStatement.setString(4, voyage.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    
    /** 
     * @return List<Voyage>
     */
    public List<Voyage> getAllVoyages() {
        List<Voyage> voyages = new ArrayList<>();
        String query = "SELECT * FROM voyage";
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String destination = resultSet.getString("destination");
                LocalDate dateDepart = resultSet.getDate("date_depart").toLocalDate();
                LocalDate dateRetour = resultSet.getDate("date_retour").toLocalDate();
                String description = resultSet.getString("description");
                voyages.add(new Voyage(destination, dateDepart, dateRetour, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyages;
    }
    public List<String> getAllDestinations() {
        List<String> destinations = new ArrayList<>();
        List<Voyage> voyages = getAllVoyages();
        for (Voyage voyage : voyages) {
            destinations.add(voyage.getDestination());
        }
        return destinations;
    }
   

    
        public int getVoyageIdByDestination(String destination) {
            int voyageId = -1; // Valeur par défaut si la destination n'est pas trouvée
            String query = "SELECT id FROM voyage WHERE destination = ?";
            try (Connection conn = getConnection();
                 PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, destination);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        voyageId = resultSet.getInt("id");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return voyageId;
        }
    }
    

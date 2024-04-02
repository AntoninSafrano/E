import java.sql.*;

public class VoyageurDAO extends DAO<Voyageur> {
    
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
     * @return Voyageur
     */
    public Voyageur select(long id) {
        Voyageur voyageur = new Voyageur();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM voyageur WHERE id=" + id);
            if (resultSet.next()) {
                voyageur.setName(resultSet.getString("name"));
                voyageur.setAge(resultSet.getInt("age"));
                voyageur.setAddress(new AdressePostaleDAO().select(resultSet.getInt("adresse_id")));
                voyageur.setBagage(new BagageDAO().select(resultSet.getInt("bagage_id")));
                voyageur.setId(resultSet.getLong("id"));
                return voyageur;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    
    /** 
     * @param voyageur
     * @return boolean
     */
    public boolean insert(Voyageur voyageur) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO voyageur (name, age, category, adresse_id, bagage_id) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, voyageur.getName());
            preparedStatement.setInt(2, voyageur.getAge());
            preparedStatement.setString(3, voyageur.getCategory());
            preparedStatement.setLong(4, voyageur.getAddress().getId());
            preparedStatement.setLong(5, voyageur.getBagage().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    
    /** 
     * @param voyageur
     * @return boolean
     */
    public boolean update(Voyageur voyageur) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE voyageur SET name=?, age=?, category=?, adresse_id=?, bagage_id=? WHERE id=?");
            preparedStatement.setString(1, voyageur.getName());
            preparedStatement.setInt(2, voyageur.getAge());
            preparedStatement.setString(3, voyageur.getCategory());
            preparedStatement.setLong(4, voyageur.getAddress().getId());
            preparedStatement.setLong(5, voyageur.getBagage().getId());
            preparedStatement.setLong(6, voyageur.getId());
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
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM voyageur WHERE id=?");
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
        // Etape 2
        // Insertion de 2 voyageurs avec leurs bagages et adresses postales
        AdressePostale adressePostale1 = new AdressePostale("Rue du Manoir", "Gotham City", 12345);
        AdressePostale adressePostale2 = new AdressePostale("Rue du Daily Planet", "Metropolis", 54321);

        Bagage bagage1 = new Bagage(1, 10, "bleu");
        Bagage bagage2 = new Bagage(2, 20, "rouge");

        // Initialisation des 3 classes DAO
        AdressePostaleDAO adressePostaleDAO = new AdressePostaleDAO();
        BagageDAO bagageDAO = new BagageDAO();
        VoyageurDAO voyageurDAO = new VoyageurDAO();

        // Insertion des adresses postales et des bagages
        adressePostaleDAO.insert(adressePostale1);
        adressePostaleDAO.insert(adressePostale2);
        bagageDAO.insert(bagage1);
        bagageDAO.insert(bagage2);

        // On les récupère pour les ajouter aux voyageurs
        adressePostale1 = adressePostaleDAO.select(1);
        adressePostale2 = adressePostaleDAO.select(2);
        bagage1 = bagageDAO.select(13);
        bagage2 = bagageDAO.select(14);

        // Création des voyageurs
        Voyageur voyageur1 = new Voyageur("Bruce Wayne", 35, adressePostale1,
                bagage1);
        Voyageur voyageur2 = new Voyageur("Clark Kent", 30, adressePostale2,
                bagage2);

        // Insertion des voyageurs
        voyageurDAO.insert(voyageur1);
        voyageurDAO.insert(voyageur2);

        // On récupère les voyageurs pour les afficher
        Voyageur voyageurAffiche = voyageurDAO.select(3);
        System.out.println(voyageurAffiche);

        // On affiche tous les voyageurs de la base de données
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/easyline", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM voyageur;");

            while (resultSet.next()) {
                System.out.println(voyageurDAO.select(resultSet.getInt("id")));
                System.out.println("================================================");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

    import java.sql.*;
    import java.util.Scanner;
    import java.util.ArrayList;

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
         * @return ArrayList<Voyageur>
         */
        public ArrayList<Voyageur> selectVoyageursSansBagage() {
            ArrayList<Voyageur> voyageursSansBagage = new ArrayList<>();
            try {
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM voyageur WHERE bagage_id IS NULL";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    Voyageur voyageur = new Voyageur();
                    voyageur.setName(resultSet.getString("name"));
                    voyageur.setAge(resultSet.getInt("age"));
                    voyageur.setAddress(new AdressePostaleDAO().select(resultSet.getInt("adresse_id")));
                    voyageur.setId(resultSet.getLong("id"));
                    voyageursSansBagage.add(voyageur);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return voyageursSansBagage;
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
                    voyageur.setId(resultSet.getLong("id"));
                    voyageur.setName(resultSet.getString("name"));
                    voyageur.setAge(resultSet.getInt("age"));
                    voyageur.setAddress(new AdressePostaleDAO().select(resultSet.getInt("adresse_id")));
                    voyageur.setBagage(new BagageDAO().select(resultSet.getInt("bagage_id")));
                    voyageur.setVoyageId(resultSet.getLong("voyage_id"));
                    return voyageur;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return null;
        }

        
        /** 
         * @return ArrayList<Voyageur>
         */
        public ArrayList<Voyageur> selectAll() {
            ArrayList<Voyageur> voyageurs = new ArrayList<>();
            try {
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM voyageur");
                while (resultSet.next()) {
                    Voyageur voyageur = new Voyageur();
                    voyageur.setName(resultSet.getString("name"));
                    voyageur.setAge(resultSet.getInt("age"));
                    voyageur.setAddress(new AdressePostaleDAO().select(resultSet.getInt("adresse_id")));
                    voyageur.setBagage(new BagageDAO().select(resultSet.getInt("bagage_id")));
    voyageur.setId(resultSet.getLong("id"));
                    long voyageId = resultSet.getLong("voyage_id");
                    Voyage voyage = voyageId != 0 ? new VoyageDAO().select(voyageId) : null;
                    voyageur.setVoyage(voyage);
                    voyageurs.add(voyageur);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return voyageurs;
        }


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
                preparedStatement.setLong(6, voyageur.getVoyageId()); // Utilisation de l'ID du voyage fourni
                preparedStatement.executeUpdate();
                preparedStatement.close();
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
            return false;
        }

        public int insertAdresse(AdressePostale adressePostale) {
            int insertedAddresseId = 0;
            try {
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT INTO adresse_postale (street, city, postal_code) VALUES (?, ?, ?)",
                                Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, adressePostale.getStreet());
                preparedStatement.setString(2, adressePostale.getCity());
                preparedStatement.setInt(3, adressePostale.getPostalCode());
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    insertedAddresseId = rs.getInt(1);
                }
                preparedStatement.close();

                return insertedAddresseId;
            } catch (Exception e) {
                System.out.println(e);
            }
            return -1;
        }

        public boolean insertVoyageurWithAdresse(Voyageur voyageur, AdressePostale adressePostale, long voyageId) {
            try {
                Connection connection = getConnection();
        
                int adresseId = insertAdresse(adressePostale);
        
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO voyageur (name, age, category, adresse_id, voyage_id) VALUES (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, voyageur.getName());
                preparedStatement.setInt(2, voyageur.getAge());
                preparedStatement.setString(3, voyageur.getCategory());
                preparedStatement.setLong(4, adresseId);
                preparedStatement.setLong(5, voyageId); // Utilisation de l'ID du voyage fourni
                preparedStatement.executeUpdate();
                preparedStatement.close();
                return true;
            } catch (Exception e) {
                System.out.println(e);
            }
            return false;
        }
        
        public boolean update(Voyageur voyageur) {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "UPDATE voyageur SET name=?, age=?, adresse_id=?, bagage_id=?, voyage_id=? WHERE id=?")) {
                preparedStatement.setString(1, voyageur.getName());
                preparedStatement.setInt(2, voyageur.getAge());
                preparedStatement.setLong(3, voyageur.getAddress().getId());
                if (voyageur.getBagage() != null) {
                    preparedStatement.setLong(4, voyageur.getBagage().getId());
                } else {
                    preparedStatement.setNull(4, Types.NULL);
                }
                // Utiliser l'ID du voyage seulement s'il est valide
                if (voyageur.getVoyageId() != 0) {
                    preparedStatement.setLong(5, voyageur.getVoyageId());
                } else {
                    preparedStatement.setNull(5, Types.NULL);
                }
                preparedStatement.setLong(6, voyageur.getId());
                int lignesModifiees = preparedStatement.executeUpdate();
                // Vérifier si des lignes ont été modifiées avec succès
                if (lignesModifiees > 0) {
                    System.out.println("Voyageur modifié avec succès.");
                    return true;
                } else {
                    System.out.println("Aucun voyageur n'a été modifié.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        
        
        
        

        public boolean delete(long id) {
            try {
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM voyageur WHERE id=?");
                preparedStatement.setLong(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                preparedStatement.close();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

       
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veuillez entrer l'ID du voyageur à mettre à jour : ");
            
            try {
                long id = scanner.nextLong();
                
                VoyageurDAO voyageurDAO = new VoyageurDAO();
                Voyageur voyageur = voyageurDAO.select(id);
                
                if (voyageur != null) {
                    // Afficher les informations actuelles du voyageur
                    System.out.println("Informations actuelles du voyageur avec l'ID " + id + " :");
                    System.out.println("Nom : " + voyageur.getName());
                    System.out.println("Âge : " + voyageur.getAge());
                    System.out.println("ID du voyage actuel : " + voyageur.getVoyageId());
                    
                    // Modifier les informations du voyageur (par exemple, le nom et l'âge)
                    System.out.println("Entrez le nouvel identifiant du voyage : ");
                    long nouvelIdVoyage = scanner.nextLong();
                    
                    // Mettre à jour les informations du voyageur
                    voyageur.setVoyageId(nouvelIdVoyage);
                    
                    // Appeler la méthode update pour mettre à jour le voyageur dans la base de données
                    if (voyageurDAO.update(voyageur)) {
                        System.out.println("Le voyageur a été mis à jour avec succès.");
                    } else {
                        System.out.println("Erreur lors de la mise à jour du voyageur.");
                    }
                } else {
                    System.out.println("Aucun voyageur trouvé avec l'ID " + id);
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la saisie de l'ID du voyageur : " + e.getMessage());
            } finally {
                scanner.close();
            }
        }        
}
    


    
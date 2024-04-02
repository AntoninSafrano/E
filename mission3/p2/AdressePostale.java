package mission3.p2;

public class AdressePostale {
    private String street, city;
    private int postalCode;

    // initialisation d'un constructeur à 3 paramètres
    public AdressePostale(String street, String city, int postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    
    /** 
     * @param street
     */
    // fonction qui permet de changer la rue d'une adresse
    public void setStreet(String street) {
        this.street = street;
    }

    
    /** 
     * @param city
     */
    // fonction qui permet de changer la ville d'une adresse
    public void setCity(String city) {
        this.city = city;
    }

    
    /** 
     * @param postalCode
     */
    // fonction qui permet de changer le code postal d'une adresse
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    
    /** 
     * @return String
     */
    // fonction qui permet de retourner la rue d'une adresse
    public String getStreet() {
        return this.street;
    }

    // fonction qui permet de retourner la ville d'une adresse
    public String getCity() {
        return this.city;
    }

    // fonction qui permet de retourner le code postal d'une adresse
    public int getPostalCode() {
        return this.postalCode;
    }

    // fonction qui affiche les informations d'un voyageur
    public void displayInfo() {
        System.out.println("Rue: " + this.street);
        System.out.println("Ville: " + this.city);
        System.out.println("Code postal: " + this.postalCode);
    }
}

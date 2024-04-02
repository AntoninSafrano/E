package mission3.p1;

public class P1 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        // initialisation d'une adresse
        AdressePostale adresse = new AdressePostale("Rue de la paix", "Paris", 75000);

        // affichage des informations de l'adresse
        adresse.displayInfo();

        // on modifie adresse
        adresse.setStreet("Eugène Blouin");
        adresse.setCity("Magny en Vexin");
        adresse.setPostalCode(95420);

        // affichage des informations de l'adresse
        adresse.displayInfo();
    }
}

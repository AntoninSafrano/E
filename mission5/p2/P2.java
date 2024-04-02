package mission5.p2;

public class P2 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        // a. tester les nouvelles foncionnalités
        AdressePostale address = new AdressePostale("Rue de la paix", "Paris", 75000);
        Bagage bagage = new Bagage(1, 10.5, "rouge");
        VoyageurPrivilege voyageur1 = new VoyageurPrivilege("Jean", 20, address, bagage, 1234);
        System.out.println(voyageur1);

        VoyageurParticularite voyageur2 = new VoyageurParticularite("John", 30, address, bagage, "Riche");
        System.out.println(voyageur2);

        // b. créer une collection de 2 voyageurs, un voyageur privilège et un voyageur
        // avec particularité puis afficher
        Voyageur voyageurs[] = new Voyageur[4];

        voyageurs[0] = new Voyageur("Adam", 23, address, bagage);
        voyageurs[1] = new Voyageur("Bruno", 24, address, bagage);
        voyageurs[2] = new VoyageurPrivilege("Charles", 25, address, bagage, 1234);
        voyageurs[3] = new VoyageurParticularite("David", 26, address, bagage, "Riche");

        for (int i = 0; i < voyageurs.length; i++) {
            System.out.println(voyageurs[i]);
        }

        // c. créer une agence de voyage et ajouter les voyageurs à la liste
        AgenceVoyage agence = new AgenceVoyage("Agence", address);

        for (int i = 0; i < voyageurs.length; i++) {
            agence.addVoyageur(voyageurs[i]);
        }

        agence.displayInfo();

        // -> il est possible d'ajouter nos voyageurs à l'agence de voyage car les
        // voyageurs particuliers et privilèges sont des sous-classes de voyageurs
    }
}

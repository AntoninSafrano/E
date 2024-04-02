package mission4.p1;

import java.util.Scanner;

public class P1 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // salut

        // voyageurs[0] = new Voyageur("Monkey D. Luffy", 19, new AdressePostale("Rue de
        // la paix", "Paris", 75000),
        // new Bagage(1, 2, "Noir"));
        // voyageurs[1] = new Voyageur("Roronoa Zoro", 21, new AdressePostale("Rue de la
        // paix", "Paris", 75000), null);
        // voyageurs[2] = new Voyageur("Nami", 20, new AdressePostale("Rue de la paix",
        // "Paris", 75000),
        // new Bagage(2, 3, "Rose"));

        System.out.println("Combien de voyageurs voulez-vous ajouter ?");
        int nbVoyageurs = sc.nextInt();
        sc.nextLine();
        Voyageur voyageurs[] = new Voyageur[nbVoyageurs];

        for (int i = 0; i < nbVoyageurs; i++) {
            System.out.println("Voyageur n°" + (i + 1));
            System.out.println("Saisir nom");
            String name = sc.nextLine();
            System.out.println("Saisir age");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Saisir rue");
            String street = sc.nextLine();
            System.out.println("Saisir ville");
            String city = sc.nextLine();
            System.out.println("Saisir code postal");
            int postalCode = sc.nextInt();
            sc.nextLine();
            System.out.println("Saisir numéro de bagage");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.println("Saisir poids de bagage (virgule pour les décimales)");
            double weight = sc.nextDouble();
            sc.nextLine();
            System.out.println("Saisir couleur de bagage");
            String color = sc.nextLine();

            voyageurs[i] = new Voyageur(name, age, new AdressePostale(street, city,
                    postalCode),
                    new Bagage(number, weight, color));
        }

        System.out.println("Voyageurs:");
        displayVoyageurs(voyageurs);

        System.out.println("Saisir le nom d'un voyageur à afficher");
        String name = sc.nextLine();
        getVoyageurByName(voyageurs, name);

        System.out.println("Saisir le nom d'un voyageur à supprimer");
        name = sc.nextLine();
        deleteVoyageurByName(voyageurs, name);

    }

    
    /** 
     * @param voyageurs[]
     */
    public static void displayVoyageurs(Voyageur voyageurs[]) {
        for (int i = 0; i < voyageurs.length; i++) {
            System.out.println(voyageurs[i].getName());
        }
    }

    
    /** 
     * @param voyageurs[]
     * @param name
     */
    public static void getVoyageurByName(Voyageur voyageurs[], String name) {
        for (int i = 0; i < voyageurs.length; i++) {
            if (voyageurs[i].getName().equals(name)) {
                voyageurs[i].displayInfo();
                return;
            }
        }
        System.out.println("Aucun voyageur avec ce nom");
    }

    
    /** 
     * @param voyageurs[]
     * @param name
     */
    public static void deleteVoyageurByName(Voyageur voyageurs[], String name) {
        for (int i = 0; i < voyageurs.length; i++) {
            if (voyageurs[i].getName().equals(name)) {
                Voyageur tmp[] = new Voyageur[voyageurs.length - 1];
                for (int j = 0; j < i; j++) {
                    tmp[j] = voyageurs[j];
                }
                for (int j = i + 1; j < voyageurs.length; j++) {
                    tmp[j - 1] = voyageurs[j];
                }
                voyageurs = tmp;
                System.out.println("Voyageurs:");
                displayVoyageurs(voyageurs);
                return;
            }
        }
        System.out.println("Aucun voyageur avec ce nom");
    }
}

package mission4.p2;

import java.util.Scanner;

public class P2 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        AgenceVoyage agence = new AgenceVoyage("Voyageur", new AdressePostale("Rue de la paix", "Paris", 75000));
        agence.displayInfo();

        agence.addVoyageur(new Voyageur("Monkey D. Luffy", 19, new AdressePostale("Rue de la paix", "Paris", 75000),
                new Bagage(1, 2, "Noir")));
        agence.addVoyageur(
                new Voyageur("Roronoa Zoro", 21, new AdressePostale("Rue de la paix", "Paris", 75000), null));
        agence.addVoyageur(new Voyageur("Nami", 20, new AdressePostale("Rue de la paix", "Paris", 75000),
                new Bagage(2, 3, "Rose")));

        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Bonjour, bienvenue dans l'agence " + agence.getName());
            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("1. Ajouter un voyageur");
            System.out.println("2. Rechercher un voyageur");
            System.out.println("3. Supprimer un voyageur");
            System.out.println("4. Afficher les informations de l'agence");
            System.out.println("5. Quitter");

            int choice = sc.nextInt();
            sc.nextLine();

            while (choice < 1 || choice > 5) {
                System.out.println("Choix invalide");
                choice = sc.nextInt();
                sc.nextLine();
            }

            if (choice == 1) {
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
                System.out
                        .println("Saisir poids de bagage (virgule ou point pour décimales selon la langue du système)");
                double weight = sc.nextDouble();
                sc.nextLine();
                System.out.println("Saisir couleur de bagage");
                String color = sc.nextLine();

                agence.addVoyageur(new Voyageur(name, age, new AdressePostale(street, city, postalCode),
                        new Bagage(number, weight, color)));
            } else if (choice == 2) {
                System.out.println("Saisir le nom d'un voyageur à afficher");
                String name = sc.nextLine();
                agence.getVoyageurByName(name);
            } else if (choice == 3) {
                System.out.println("Saisir le nom d'un voyageur à supprimer");
                String name = sc.nextLine();
                agence.deleteVoyageurByName(name);
            } else if (choice == 4) {
                agence.displayInfo();
            } else if (choice == 5) {
                System.out.println("Au revoir");
                running = false;
            }
        }

        sc.close();
        System.exit(0);
    }
}

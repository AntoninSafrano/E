package mission1;

import java.util.Scanner;

public class Voyageur {
    public String nom; // Le nom du voyageur
    public int age;     // L'âge du voyageur

    // Constructeur par défaut : crée un voyageur avec un nom par défaut et un âge de 0
    public Voyageur() {
        this.nom = "Marge Simpson";
        this.age = 14;
    }

    // Constructeur personnalisé : crée un voyageur avec un nom et un âge spécifiés
    public Voyageur(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    // Méthode pour afficher les informations du voyageur
    public void afficherInfos() {
        System.out.println("Nom: " + this.nom);
        System.out.println("Âge: " + this.age);
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Crée un voyageur avec le constructeur personnalisé
        Voyageur v1 = new Voyageur("tae jones", 18);
        v1.afficherInfos();

        // Crée un voyageur avec le constructeur par défaut
        Voyageur v2 = new Voyageur();
        v2.afficherInfos();

        System.out.println("Entrez le nom :");
        v1.nom = sc.nextLine(); // Modifie le nom du voyageur
        System.out.println("Entrez l'âge :");
        v1.age = sc.nextInt(); // Modifie l'âge du voyageur

        v1.afficherInfos();
    }
}

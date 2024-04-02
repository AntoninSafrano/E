package mission1;

public class Voyageur2 {
    private String nom; // Le nom du voyageur
    private int age;     // L'âge du voyageur

    // Constructeur par défaut : crée un voyageur avec un nom par défaut et un âge de 0
    public Voyageur2() {
        this.nom = "Marge Simpson";
        this.age = 14;
    }

    // Constructeur personnalisé : crée un voyageur avec un nom et un âge spécifiés
    public Voyageur2(String nom, int age) {
        // Vérifie la validité du nom et de l'âge fournis
        if (nom.length() < 2) {
            throw new IllegalArgumentException("Le nom doit faire au moins 2 caractères");
        }
        if (age < 0) {
            throw new IllegalArgumentException("L'âge doit être un nombre positif");
        }
        this.nom = nom;
        this.age = age;
    }

    
    /** 
     * @param nom
     */
    // Méthode pour changer le nom du voyageur
    public void setNom(String nom) {
        // Vérifie la validité du nouveau nom
        if (nom.length() < 2) {
            throw new IllegalArgumentException("Le nom doit faire au moins 2 caractères");
        }
        this.nom = nom;
    }

    
    /** 
     * @param age
     */
    // Méthode pour changer l'âge du voyageur
    public void setAge(int age) {
        // Vérifie la validité du nouvel âge
        if (age < 0) {
            throw new IllegalArgumentException("L'âge doit être un nombre positif");
        }
        this.age = age;
    }

    
    /** 
     * @return String
     */
    // Méthode pour obtenir le nom du voyageur
    public String getNom() {
        return this.nom;
    }

    
    /** 
     * @return int
     */
    // Méthode pour obtenir l'âge du voyageur
    public int getAge() {
        return this.age;
    }

    // Méthode pour afficher les informations du voyageur
    public void afficherInfos() {
        System.out.println("Nom: " + this.nom);
        System.out.println("Âge: " + this.age);
    }

    public static void main(String[] args) {
        Voyageur2 v1 = new Voyageur2("Tae Jones", 18);
        System.out.println(v1.getAge());
        
        v1.setNom("Trae Young");//chager le nom du voyageur v1
        System.out.println(v1.getNom());//affiche le nouveau nom du voyageur v1

        v1.setAge(-1); // Tentative de définir un âge négatif (générera une erreur)
        System.out.println(v1.getAge());
    }
}

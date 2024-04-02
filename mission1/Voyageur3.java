package mission1;

public class Voyageur3 {
    private String nom, categorie; // Le nom du voyageur et sa catégorie d'âge
    private int age;             // L'âge du voyageur

    // Constructeur par défaut : crée un voyageur avec un nom par défaut, un âge de 14, et définit sa catégorie
    public Voyageur3() {
        this.nom = "Marge Simpson";
        this.age = 14;

        setCategory();
    }

    // Constructeur personnalisé : crée un voyageur avec un nom et un âge spécifiés, et définit sa catégorie
    public Voyageur3(String nom, int age) {
        // Vérifie la validité du nom et de l'âge fournis
        if (nom.length() < 2) {
            throw new IllegalArgumentException("Le nom doit faire au moins 2 caractères");
        }
        if (age < 0) {
            throw new IllegalArgumentException("L'âge doit être un nombre positif");
        }
        this.nom = nom;
        this.age = age;

        setCategory();
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
    // Méthode pour changer l'âge du voyageur et redéfinir sa catégorie
    public void setAge(int age) {
        // Vérifie la validité du nouvel âge
        if (age < 0) {
            throw new IllegalArgumentException("L'âge doit être un nombre positif");
        }
        this.age = age;
        setCategory();
    }

    // Méthode pour déterminer la catégorie d'âge du voyageur en fonction de son âge
    public void setCategory() {
        if (this.age < 1)
            this.categorie = "Nourrisson";
        else if (this.age < 18)
            this.categorie = "Enfant";
        else if (this.age < 60)
            this.categorie = "Adulte";
        else
            this.categorie = "Senior";
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

    // Méthode pour obtenir la catégorie d'âge du voyageur
    public String getCategorie() {
        return this.categorie;
    }

    // Méthode pour afficher les informations du voyageur
    public void afficherInfos() {
        System.out.println("Nom: " + this.nom);
        System.out.println("Âge: " + this.age);
    }

    public static void main(String[] args) {
        // Crée un nouvel objet "Voyageur3" appelé "v1" avec le nom "Tae Jones" et l'âge 18
        Voyageur3 v1 = new Voyageur3("Tae Jones", 18);
    
        // Affiche l'âge du voyageur "v1" en utilisant la méthode "getAge()"
        System.out.println("Âge: " + v1.getAge());
    
        // Affiche la catégorie d'âge du voyageur "v1" en utilisant la méthode "getCategorie()"
        System.out.println("Catégorie d'âge: " + v1.getCategorie());
    
        // Change l'âge du voyageur "v1" en 43 ans
        v1.setAge(43);
    
        // Affiche la nouvelle catégorie d'âge du voyageur "v1" après la modification de l'âge
        System.out.println("Nouvelle catégorie d'âge: " + v1.getCategorie());
    }
    
}

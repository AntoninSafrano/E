package mission3.p1;

public class Voyageur {
    private String name, category;
    private int age;

    // initialisation d'un constructeur sans paramètres (donc par défaut)
    public Voyageur() {
        this.name = "John Doe";
        this.age = 0;

        setCategory();
    }

    // initialisation d'un constructeur qui prend un nom et un age en paramètres
    public Voyageur(String name, int age) {

        // si le nom est inférieur à 2 caractères, retourner une erreur
        if (name.length() < 2)
            throw new IllegalArgumentException("Le nom doit faire au moins 2 caractères");

        // si le'age est inférieur à 0, retourner une erreur
        if (age < 0)
            throw new IllegalArgumentException("L'age doit être un nombre positif");
        this.name = name;
        this.age = age;

        setCategory();
    }

    
    /** 
     * @param name
     */
    // fonction qui permet de changer le nom d'un voyageur
    public void setName(String name) {

        // si le nom est inférieur à 2 caractères, retourner une erreur
        if (name.length() < 2)
            throw new IllegalArgumentException("Le nom doit faire au moins 2 caractères");
        this.name = name;
    }

    
    /** 
     * @param age
     */
    // fonction qui permet de changer l'age d'un voyageur
    public void setAge(int age) {

        // si le'age est inférieur à 0, retourner une erreur
        if (age < 0)
            throw new IllegalArgumentException("L'age doit être un nombre positif");
        this.age = age;
        setCategory();
    }

    public void setCategory() {
        if (this.age < 1)
            this.category = "Nourrisson";
        else if (this.age < 18)
            this.category = "Enfant";
        else if (this.age < 60)
            this.category = "Adulte";
        else
            this.category = "Senior";
    }

    
    /** 
     * @return String
     */
    // fonction qui permet de retourner le nom d'un voyageur
    public String getName() {
        return this.name;
    }

    
    /** 
     * @return int
     */
    // fonction qui permet de retourner l'age d'un voyageur
    public int getAge() {
        return this.age;
    }

    // fonction qui permet de retourner la catégorie d'un voyageur
    public String getCategory() {
        return this.category;
    }

    // fonction qui affiche les informations d'un voyageur
    public void displayInfo() {
        System.out.println("Nom: " + this.name);
        System.out.println("Age: " + this.age);
    }
}

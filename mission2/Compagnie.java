package mission2;

import java.util.Scanner;

public class Compagnie {
    public String nom;
    public int code;
    public double ca;
    public String couleurPrincipaleLogo;
    public String couleurSecondaireLogo;
    private String password;

    public Compagnie() {
    }

    public Compagnie(String nomCompagnie) {
        this.nom = nomCompagnie;
    }

    // initialisation d'un constructeur qui prend un nom, une couleur principale et
    // une couleur secondaire en paramètres
    public Compagnie(String nomCompagnie, String couleurPrincipaleLogo, String couleurSecondaireLogo) {
        this.nom = nomCompagnie;
        this.couleurPrincipaleLogo = couleurPrincipaleLogo;
        this.couleurSecondaireLogo = couleurSecondaireLogo;
    }

    // initialisation d'un constructeur qui prend un nom, une couleur principale,
    // une couleur secondaire et un code en paramètres
    public Compagnie(String nomCompagnie, String couleurPrincipaleLogo, String couleurSecondaireLogo, int code) {
        this.nom = nomCompagnie;
        this.couleurPrincipaleLogo = couleurPrincipaleLogo;
        this.couleurSecondaireLogo = couleurSecondaireLogo;
        this.code = code;
    }

    public void afficher() {
        // on affiche le nom de la compagnie, son code et sa couleur principale
        System.out.println(this.nom);
        System.out.println("Code : " + this.code);
        System.out.println("Couleur principale : " + this.couleurPrincipaleLogo);
        System.out.println("Couleur secondaire : " + this.couleurSecondaireLogo);
    }

    // on crée une fonction qui permet de modifier le mot de passe de la compagnie
    // pour accéder à différentes infos
    public void setPassword() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choisissez un mot de passe pour la compagnie :");
        this.password = sc.nextLine();

        System.out.println("Mot de passe enregistré !");
    }

    
    /** 
     * @return int
     */
    // on crée les acceseurs pour tout les attributs de la classe
    public int getCode() {
        // on a besoin d'entrer un mot de passe pour obtenir le code
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le mot de passe pour obtenir le code :");
        String password = sc.nextLine();

        if (password.equals(this.password)) {
            return this.code;
        } else {
            System.out.println("Mot de passe incorrect, pas de code pour vous !");
            return 0;
        }
    }

    
    /** 
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    
    /** 
     * @return double
     */
    public double getCA() {
        return this.ca;
    }

    
    /** 
     * @return String
     */
    public String getCouleurPrincipaleLogo() {
        return this.couleurPrincipaleLogo;
    }

    public String getCouleurSecondaireLogo() {
        return (this.couleurSecondaireLogo + " second");
    }

    // on crée les modificateurs pour tout les attributs de la classe
    public void setCode(int code) {
        // on a besoin d'entrer un mot de passe pour modifier le code
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le mot de passe pour modifier le code :");
        String password = sc.nextLine();

        if (password.equals(this.password)) {
            this.code = code;
            System.out.println("Code modifié avec succès !");
        } else {
            System.out.println("Mot de passe incorrect, pas de modification de code pour vous !");
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCA(double ca) {
        // on a besoin d'entrer un mot de passe pour modifier le CA
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le mot de passe pour modifier le CA :");
        String password = sc.nextLine();

        if (password.equals(this.password)) {
            this.ca = ca;
            System.out.println("CA modifié avec succès !");
        } else {
            System.out.println("Mot de passe incorrect, pas de modification de CA pour vous !");
        }

        // on falsifie le CA en l'augmentant de 30%
        this.ca = this.ca * 1.3;
    }

    public void setCouleurPrincipaleLogo(String couleurPrincipaleLogo) {
        this.couleurPrincipaleLogo = couleurPrincipaleLogo;
    }

    public void setCouleurSecondaireLogo(String couleurSecondaireLogo) {
        this.couleurSecondaireLogo = couleurSecondaireLogo;
    }

    public static void main(String[] args) {
        Compagnie maCompagnie1 = new Compagnie();
        maCompagnie1.nom = "zaza";
        maCompagnie1.afficher();
        Compagnie maCompagnie2 = new Compagnie("zozo");

        // on crée une compagnie qui s'appelle easyJune
        Compagnie maCompagnie3 = new Compagnie("easyJune");

        // on crée une compagnie qui s'appelle easyJune avec le constructeur à un
        // argument
        Compagnie maCompagnie4 = new Compagnie("Nintendo");

        // on crée une compagnie qui s'appelle easyJune avec le constructeur sans
        // argument
        Compagnie maCompagnie5 = new Compagnie();
        maCompagnie5.nom = "Valve";

        // on ajoute un code à la compagnie zaza
        maCompagnie1.code = 156;

        // on affiche le code de la compagnie zaza
        System.out.println(maCompagnie1.code);

        // on affiche le nom de la compagnie zozo
        maCompagnie2.code = 142;

        // on affiche le code de la compagnie zozo
        System.out.println(maCompagnie2.code);

        // on ajoute une couleur principale à la compagnie zaza
        maCompagnie1.couleurPrincipaleLogo = "orange";

        // on affiche la couleur principale de la compagnie zaza
        System.out.println(maCompagnie1.couleurPrincipaleLogo);

        // on affiche la compagnie zozo avec la fonction afficher
        maCompagnie2.afficher();

        // on donne un code et une couleur principale à la compagnie zozo et on les
        // affiche
        maCompagnie2.couleurPrincipaleLogo = "rose";
        maCompagnie2.afficher();

        // on donne un code et une couleur principale à la compagnie easyJune et on les
        // affiche
        maCompagnie3.code = 65;
        maCompagnie3.couleurPrincipaleLogo = "jaune";
        maCompagnie3.afficher();

        // on donne un code et une couleur principale à la compagnie Nintendo et on les
        // affiche
        maCompagnie4.code = 75;
        maCompagnie4.couleurPrincipaleLogo = "rouge";
        maCompagnie4.afficher();

        // on donne un code et une couleur principale à la compagnie Valve et on les
        // affiche
        maCompagnie5.code = 498;
        maCompagnie5.couleurPrincipaleLogo = "bleu";
        maCompagnie5.afficher();

        // on donne une couleur secondaire à la compagnie zaza
        maCompagnie1.couleurSecondaireLogo = "vert";

        // on affiche les couleurs principale et secondaire de la compagnie zaza
        System.out.println("La couleur principale de Zaza est " + maCompagnie1.couleurPrincipaleLogo);
        System.out.println("La couleur secondaire de Zaza est " + maCompagnie1.couleurSecondaireLogo);

        // on crée une compagnie 6 avec le nouveau constructeur à 3 arguments
        Compagnie maCompagnie6 = new Compagnie("Instagram", "violet", "jaune");

        // on affiche la compagnie 6
        maCompagnie6.afficher();

        // on crée une compagnie 7 avec le nouveau constructeur à 4 arguments
        Compagnie maCompagnie7 = new Compagnie("Facebook", "bleu", "rouge", 23);

        // on affiche la compagnie 7
        maCompagnie7.afficher();

        // on affiche le code de la compagnie 6
        System.out.println(maCompagnie6.code);

        // on demande de créer un mot de passe pour la compagnie 7
        maCompagnie7.setPassword();

        // on affiche le code de la compagnie 7
        System.out.println(maCompagnie7.getCode());

        // on affiche la couleur secondaire de la compagnie 7 suivie du mot second
        System.out.println(maCompagnie7.getCouleurSecondaireLogo());

        // on verifie le mot de passe pour toute modification de code de la compagnie 7
        maCompagnie7.setCode(777);

        // on demande le mot de passe pour modifier le CA de la compagnie 7
        maCompagnie7.setCA(3000000);
    }
}

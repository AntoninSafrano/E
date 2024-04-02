package mission4.p2;

public class AgenceVoyage {
    private String name;
    private AdressePostale address;
    private Voyageur voyageurs[];

    // initialisation d'un constructeur à 2 paramètres
    public AgenceVoyage(String name, AdressePostale address) {
        this.name = name;
        this.address = address;
        this.voyageurs = new Voyageur[5];
    }

    public void displayInfo() {
        System.out.println("Nom de l'agence: " + this.name);
        System.out.println("Adresse: ");
        this.address.displayInfo();
        System.out.println("Voyageurs: ");
        displayVoyageurs();

    }

    public void displayVoyageurs() {
        for (int i = 0; i < this.voyageurs.length; i++) {
            if (this.voyageurs[i] == null) {
                return;
            }
            System.out.println(this.voyageurs[i].getName());
        }
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @return AdressePostale
     */
    public AdressePostale getAddress() {
        return this.address;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @param address
     */
    public void setAddress(AdressePostale address) {
        this.address = address;
    }

    public void addVoyageur(Voyageur voyageur) {
        for (int i = 0; i < this.voyageurs.length; i++) {
            if (this.voyageurs[i] == null) {
                this.voyageurs[i] = voyageur;
                return;
            }
        }
        System.out.println("Impossible d'ajouter un voyageur, la liste est pleine");
    }

    public void getVoyageurByName(String name) {
        for (int i = 0; i < this.voyageurs.length; i++) {
            if (this.voyageurs[i].getName().equals(name)) {
                this.voyageurs[i].displayInfo();
                return;
            }
        }
        System.out.println("Aucun voyageur avec ce nom");
    }

    public void deleteVoyageurByName(String name) {
        for (int i = 0; i < this.voyageurs.length; i++) {
            if (this.voyageurs[i].getName().equals(name)) {
                Voyageur tmp[] = new Voyageur[this.voyageurs.length - 1];
                for (int j = 0; j < i; j++) {
                    tmp[j] = this.voyageurs[j];
                }
                for (int j = i + 1; j < this.voyageurs.length; j++) {
                    tmp[j - 1] = this.voyageurs[j];
                }
                this.voyageurs = tmp;
                System.out.println("Voyageurs:");
                displayVoyageurs();
                return;
            }
        }
        System.out.println("Aucun voyageur avec ce nom");
    }
}

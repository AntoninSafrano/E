package mission5.p3;

public class VoyageurParticularite extends Voyageur {
    private String particularite;

    public VoyageurParticularite(String name, int age, AdressePostale address, Bagage bagage, String particularite) {
        super(name, age, address, bagage);
        this.particularite = particularite;
    }

    public VoyageurParticularite(String name, int age, AdressePostale address, String particularite) {
        super(name, age, address);
        this.particularite = particularite;
    }

    
    /** 
     * @param particularite
     */
    public void setParticularite(String particularite) {
        this.particularite = particularite;
    }

    
    /** 
     * @return String
     */
    public String getParticularite() {
        return this.particularite;
    }

    public void displayInfo() {
        System.out.println("Nom: " + this.name);
        System.out.println("Age: " + this.age);

        System.out.println("Adresse");
        this.address.displayInfo();

        System.out.println("Bagage");
        if (this.bagage != null)
            this.bagage.displayInfo();
        else
            System.out.println("Aucun bagage");
        System.out.println("Particularité: " + this.particularite);
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "Nom: " + this.name + "\nAge: " + this.age + "\nAdresse: " + this.address + "\nBagage: " + this.bagage
                + "\nParticularité: " + this.particularite;
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        AdressePostale address = new AdressePostale("Rue de la paix", "Paris", 75000);
        Bagage bagage = new Bagage(1, 10.5, "rouge");
        VoyageurParticularite voyageur = new VoyageurParticularite("Jean", 20, address, bagage, "Riche");
        voyageur.displayInfo();
    }
}

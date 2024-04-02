package mission5.p3;

public class VoyageurPrivilege extends Voyageur {
    private int codePrivilege;

    public VoyageurPrivilege(String name, int age, AdressePostale address, Bagage bagage, int codePrivilege) {
        super(name, age, address, bagage);
        this.codePrivilege = codePrivilege;
    }

    public VoyageurPrivilege(String name, int age, AdressePostale address, int codePrivilege) {
        super(name, age, address);
        this.codePrivilege = codePrivilege;
    }

    
    /** 
     * @param codePrivilege
     */
    public void setCodePrivilege(int codePrivilege) {
        this.codePrivilege = codePrivilege;
    }

    
    /** 
     * @return int
     */
    public int getCodePrivilege() {
        return this.codePrivilege;
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
        System.out.println("Code privilège: " + this.codePrivilege);
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "Nom: " + this.name + "\nAge: " + this.age + "\nAdresse: " + this.address + "\nBagage: " + this.bagage
                + "\nCode privilège: " + this.codePrivilege;
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        AdressePostale address = new AdressePostale("Rue de la paix", "Paris", 75000);
        Bagage bagage = new Bagage(1, 10.5, "rouge");
        VoyageurPrivilege voyageur = new VoyageurPrivilege("Jean", 20, address, bagage, 1234);
        voyageur.displayInfo();
    }
}

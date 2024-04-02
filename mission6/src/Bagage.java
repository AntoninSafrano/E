public class Bagage {
    private int number;
    private double weight;
    private String color;
    private long id;

    // initialisation d'un constructeur à 0 paramètre
    public Bagage() {
        this.number = 0;
        this.weight = 0;
        this.color = "noir";
    }

    // initialisation d'un constructeur à 3 paramètres
    public Bagage(int number, double weight, String color) {
        this.number = number;
        this.weight = weight;
        this.color = color;
    }

    
    /** 
     * @param number
     */
    // fonction qui permet de changer le numéro d'un bagage
    public void setNumber(int number) {
        this.number = number;
    }

    
    /** 
     * @param weight
     */
    // fonction qui permet de changer le poids d'un bagage
    public void setWeight(double weight) {
        this.weight = weight;
    }

    
    /** 
     * @param color
     */
    // fonction qui permet de changer la couleur d'un bagage
    public void setColor(String color) {
        this.color = color;
    }

    
    /** 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    // fonction qui permet de retourner le numéro d'un bagage
    public int getNumber() {
        return this.number;
    }

    // fonction qui permet de retourner le poids d'un bagage
    public double getWeight() {
        return this.weight;
    }

    // fonction qui permet de retourner la couleur d'un bagage
    public String getColor() {
        return this.color;
    }

    public long getId() {
        return this.id;
    }

    // fonction qui permet d'afficher les informations d'un bagage
    public void displayInfo() {
        System.out
                .println("Bagage n°" + this.number + " de couleur " + this.color + " et pesant " + this.weight + " kg");
    }

    public String toString() {
        return "Bagage n°" + this.number + " de couleur " + this.color + " et pesant " + this.weight + " kg";
    }

    public static void main(String[] args) {
        Bagage bagage1 = new Bagage();
        Bagage bagage2 = new Bagage(2, 20, "rouge");

        bagage1.displayInfo();
        bagage2.displayInfo();
    }
}

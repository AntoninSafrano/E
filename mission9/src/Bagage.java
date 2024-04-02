public class Bagage {
    private int number;
    private double weight;
    private String color;
    private long id;

    public Bagage() {
        this.number = 0;
        this.weight = 0;
        this.color = "bleu";
    }

    public Bagage(int number, double weight, String color) {
        this.number = number;
        this.weight = weight;
        this.color = color;
    }

    
    /** 
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    
    /** 
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    
    /** 
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    
    /** 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return this.number;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    public long getId() {
        return this.id;
    }

    // permet d'afficher les informations d'un bagage
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

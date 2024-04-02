package mission5.p3;

public class Bagage {
    private int number;
    private double weight;
    private String color;

    public Bagage(int number, double weight, String color) {
        this.number = number;
        this.weight = weight;
        this.color = color;
    }

    
    /** 
     * @param number
     */
    // permet de changer le numéro d'un bagage
    public void setNumber(int number) {
        this.number = number;
    }

    
    /** 
     * @param weight
     */
    // permet de changer le poids d'un bagage
    public void setWeight(double weight) {
        this.weight = weight;
    }

    
    /** 
     * @param color
     */
    // permet de changer la couleur d'un bagage
    public void setColor(String color) {
        this.color = color;
    }

    
    /** 
     * @return int
     */
    // permet de retourner le numéro d'un bagage
    public int getNumber() {
        return this.number;
    }

    // permet de retourner le poids d'un bagage
    public double getWeight() {
        return this.weight;
    }

    // permet de retourner la couleur d'un bagage
    public String getColor() {
        return this.color;
    }

    // permet d'afficher les informations d'un bagage
    public void displayInfo() {
        System.out
                .println("Bagage n°" + this.number + " de couleur " + this.color + " et pesant " + this.weight + " kg");
    }

    public String toString() {
        return "Bagage n°" + this.number + " de couleur " + this.color + " et pesant " + this.weight + " kg";
    }
}

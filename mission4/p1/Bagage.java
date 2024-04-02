package mission4.p1;

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
     * @return int
     */
    public int getNumber() {
        return this.number;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    // permet d'afficher les informations d'un bagage
    public void displayInfo() {
        System.out
                .println("Bagage n°" + this.number + " de couleur " + this.color + " et pesant " + this.weight + " kg");
    }
}

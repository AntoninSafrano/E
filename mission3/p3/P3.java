package mission3.p3;

public class P3 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Bagage bag = new Bagage(1, 10.2, "violet");
        bag.displayInfo();

        bag.setNumber(2);
        bag.setWeight(12.3);
        bag.setColor("rouge");
        bag.displayInfo();
    }
}

package mission3.p4;

public class P4 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Voyageur v1 = new Voyageur("Bruce Wayne", 40, new AdressePostale("Wayne Manor", "Gotham", 12345));
        v1.displayInfo();

        v1.setBagage(new Bagage(1, 4.5, "noir"));
        v1.displayInfo();

        v1.getBagage().setColor("bleu");
        v1.displayInfo();

        v1.setBagage(null);
        v1.displayInfo();
    }
}

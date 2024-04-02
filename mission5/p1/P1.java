package mission5.p1;

public class P1 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Voyageur voyageur1 = new Voyageur("Edward Elric", 25, new AdressePostale("Rue de la paix", "Paris", 75000),
                new Bagage(1, 2, "Noir"));

        System.out.println(voyageur1);
    }
}

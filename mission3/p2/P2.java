package mission3.p2;

public class P2 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Voyageur v1 = new Voyageur("Bruce Wayne", 40, new AdressePostale("Wayne Manor", "Gotham", 12345));
        v1.displayInfo();

        v1.getAddress().setStreet("Daily Planet");
        v1.getAddress().setCity("Metropolis");
        v1.getAddress().setPostalCode(54321);
        v1.displayInfo();
    }
}

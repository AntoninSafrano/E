package mission5.p3;

public class P3 {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Voyageur voyageurs[] = new Voyageur[10];

        voyageurs[0] = new VoyageurPrivilege("Alice Smith", 25, new AdressePostale("456 Oak Street", "New York", 10001),
                new Bagage(2, 15.0, "bleu"), 2000);
        voyageurs[1] = new VoyageurPrivilege("John Davis", 40, new AdressePostale("789 Maple Avenue", "Los Angeles", 90001),
                new Bagage(3, 20.5, "vert"), 1800);
        voyageurs[2] = new VoyageurPrivilege("Emily Brown", 30, new AdressePostale("123 Pine Lane", "Chicago", 60601),
                new Bagage(1, 12.5, "rouge"), 2200);
        voyageurs[3] = new VoyageurPrivilege("David White", 35, new AdressePostale("789 Cedar Road", "Houston", 77001),
                new Bagage(2, 18.0, "noir"), 1900);
        voyageurs[4] = new VoyageurPrivilege("Sophia Miller", 28, new AdressePostale("101 Elm Boulevard", "Miami", 33101),
                new Bagage(1, 14.5, "jaune"), 2100);
        voyageurs[5] = new VoyageurParticularite("Olivia Wilson", 22,
                new AdressePostale("202 Walnut Street", "San Francisco", 94101), new Bagage(2, 17.0, "violet"), "VIP");
        voyageurs[6] = new VoyageurParticularite("Ethan Johnson", 25,
                new AdressePostale("303 Birch Avenue", "Seattle", 98101), new Bagage(1, 13.5, "orange"), "VIP");
        voyageurs[7] = new VoyageurParticularite("Ava Davis", 32, new AdressePostale("404 Spruce Lane", "Dallas", 75201),
                new Bagage(3, 19.5, "marron"), "VIP");
        voyageurs[8] = new VoyageurParticularite("Liam Brown", 27,
                new AdressePostale("505 Sycamore Road", "Atlanta", 30301), new Bagage(2, 16.0, "rose"), "VIP");
        voyageurs[9] = new VoyageurParticularite("Emma Wilson", 23,
                new AdressePostale("606 Cedar Street", "Denver", 80201), "VIP");

        for (int i = 0; i < voyageurs.length; i++) {
            if (voyageurs[i] == null) {
                return;
            }
            voyageurs[i].displayInfo();
            System.out.println();
        }
    }
}

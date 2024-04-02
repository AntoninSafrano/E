import java.time.LocalDate;

public class Voyage {
    private String destination;
    private LocalDate dateDepart;
    private LocalDate dateRetour;
    private String description;
    private long id;

    
    /** 
     * @return long
     */
    public long getId() {
        return id;
    }

    public Voyage(String destination, LocalDate dateDepart, LocalDate dateRetour, String description) {
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.description = description;
    }

    
    /** 
     * @return String
     */
    public String getDestination() {
        return destination;
    }

    
    /** 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    
    /** 
     * @param destination
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + "\nDate de départ: " + dateDepart + "\nDate de départ: " + dateRetour;
            
    }
}
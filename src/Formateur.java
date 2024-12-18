public class Formateur {
    private int id;
    private String nom;
    private String prenom;

    // Constructor
    public Formateur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getter for Nom
    public String getNom() {
        return nom;
    }

    // Getter for Prenom (if needed)
    public String getPrenom() {
        return prenom;
    }
}

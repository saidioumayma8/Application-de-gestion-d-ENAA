public class Apprenant {
    private int id;
    private String nom;
    private String prenom;
    private String email;

    // Constructor to initialize the Apprenant object
    public Apprenant(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters and setters for each field (optional, for easier access/modification)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method to display Apprenant's details
    @Override
    public String toString() {
        return "Apprenant [ID=" + id + ", Nom=" + nom + ", Prenom=" + prenom + ", Email=" + email + "]";
    }
}

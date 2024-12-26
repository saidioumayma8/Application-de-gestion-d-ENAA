abstract class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String email;


    public Personne(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
public Personne(){

}

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Personne [ID=" + id + ", Nom=" + nom + ", Prenom=" + prenom + ", Email=" + email + "]";
    }
}

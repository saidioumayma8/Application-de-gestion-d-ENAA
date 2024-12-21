import java.util.ArrayList;
import java.util.List;

public class classe {
    private int id;
    private String nom;
    private Formateur formateur;
    private List<Apprenant> apprenants = new ArrayList<>();

    // Constructor
    public classe(int id, String nom, Formateur formateur) {
        this.id = id;
        this.nom = nom;
        this.formateur = formateur;
    }

    // Add Apprenant to this class
    public void addApprenant(Apprenant apprenant) {
        apprenants.add(apprenant);
    }

    // Display Class information
    @Override
    public String toString() {
        return "Classe ID: " + id +
                ", Name: " + nom +
                ", Formateur: " + (formateur != null ? formateur.getNom() : "None") +
                ", Apprenants: " + apprenants.size();
    }

    // Getter for Class Name
    public String getNom() {
        return nom;
    }

    // Getter for Formateur
    public Formateur getFormateur() {
        return formateur;
    }

    // Getter for Apprenants
    public List<Apprenant> getApprenants() {
        return apprenants;
    }

    // Getter for Class ID
    public int getId() {
        return id;
    }
}

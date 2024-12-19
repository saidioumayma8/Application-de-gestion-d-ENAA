import java.util.ArrayList;

public class classe {
    private int id;
    private String nom;
    private Formateur formateur;
    private ArrayList<Apprenant> apprenants;


    public classe(int id, String nom, Formateur formateur) {
        this.id = id;
        this.nom = nom;
        this.formateur = formateur;
        this.apprenants = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setformateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public ArrayList<Apprenant> getApprenants() {
        return apprenants;
    }


    public void addApprenant(Apprenant apprenant) {
        apprenants.add(apprenant);
    }


    public void removeApprenant(Apprenant apprenant) {
        apprenants.remove(apprenant);
    }

    @Override
    public String toString() {
        return "Classe ID: " + id +
                ", Nom: " + nom +
                ", Formateur: " + (formateur != null ? formateur.getNom() : "None") +
                ", Apprenants: " + apprenants.size();
    }
}

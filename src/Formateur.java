public class Formateur extends Personne {
    private String specialite;
    private double salaire;
    private classe classe;

    public Formateur(int id, String nom, String prenom, String email, String specialite, double salaire) {
        super(id, nom, prenom, email);
        this.specialite = specialite;
        this.salaire = salaire;
    }

public Formateur() {
super();
}

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {

        this.salaire = salaire;
    }

    public classe getClasse() {
        return classe;
    }

    public void setClasse(classe classe) {
        this.classe = classe;  // Ensure a class is assigned to a formateur
    }

    @Override
    public String toString() {
        return super.toString() + ", Specialité: " + specialite + ", Salaire: " + salaire;
    }
}

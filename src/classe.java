import java.util.ArrayList;

public class classe {
    private int id;
    private String name;
    private Formateur formateur; // class has one formateur
    private ArrayList<Apprenant> apprenants; // class has many apprenants

    public classe(int id, String name, Formateur formateur) {
        this.id = id;
        this.name = name;
        this.formateur = formateur;
        this.apprenants = new ArrayList<>();
    }

    // Add an apprenant to the class
    public void addApprenant(Apprenant apprenant) {
        apprenants.add(apprenant);
    }

    // Remove an apprenant by ID
    public void removeApprenant(int apprenantId) {
        apprenants.removeIf(apprenant -> apprenant.getId() == apprenantId);
    }

    // View all apprenants in the class
    public void viewApprenants() {
        if (apprenants.isEmpty()) {
            System.out.println("No apprenants in this class.");
        } else {
            for (Apprenant apprenant : apprenants) {
                System.out.println(apprenant);
            }
        }
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Formateur getFormateur() {
        return formateur;
    }
}

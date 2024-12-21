import java.util.ArrayList;
import java.util.Scanner;

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


    private static void manageClasses(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Classes ---");
            System.out.println("1. Create Class");
            System.out.println("2. View Classes");
            System.out.println("3. Assign Apprenant to Class");
            System.out.println("4. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createClass(scanner);
                    break;
                case 2:
                    viewClasses();
                    break;
                case 3:
                    assignApprenantToClass();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createClass(Scanner scanner) {
        System.out.println("Enter Class ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Class Name:");
        String nom = scanner.nextLine();

        if (formateurs.isEmpty()) {
            System.out.println("No formateurs available. Add a formateur first.");
            return;
        }

        System.out.println("Select Formateur by Index:");
        for (int i = 0; i < formateurs.size(); i++) {
            System.out.println(i + ". " + formateurs.get(i).getNom());
        }
        int formateurIndex = scanner.nextInt();
        scanner.nextLine();

        if (formateurIndex < 0 || formateurIndex >= formateurs.size()) {
            System.out.println("Invalid index. Returning to menu.");
            return;
        }

        Formateur formateur = formateurs.get(formateurIndex);
        classe classe = new classe(id, nom, formateur);
        classes.add(classe);

        System.out.println("Class created successfully!");


    }

    private static void viewClasses() {
        if (classes.isEmpty()) {
            System.out.println("No classes available.");
            return;
        }

        for (classe classe : classes) {
            System.out.println(classe);
        }
    }

    private static void assignApprenantToClass() {
        if (apprenants.isEmpty()) {
            System.out.println("No apprenants available. Add apprenants first.");
            return;
        }
        if (classes.isEmpty()) {
            System.out.println("No classes available. Create a class first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);


        System.out.println("Select an Apprenant to assign:");
        for (int i = 0; i < apprenants.size(); i++) {
            System.out.println(i + ". " + apprenants.get(i));
        }
        int apprenantIndex = scanner.nextInt();
        scanner.nextLine();

        if (apprenantIndex < 0 || apprenantIndex >= apprenants.size()) {
            System.out.println("Invalid Apprenant selection.");
            return;
        }

        Apprenant selectedApprenant = apprenants.get(apprenantIndex);

        // Display and select Classe
        System.out.println("Select a Class to assign the Apprenant to:");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println(i + ". " + classes.get(i));
        }
        int classIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (classIndex < 0 || classIndex >= classes.size()) {
            System.out.println("Invalid Class selection.");
            return;
        }

        classe selectedClass = classes.get(classIndex);

        // Assign Apprenant to Classe
        selectedClass.addApprenant(selectedApprenant);
        System.out.println("Apprenant " + selectedApprenant.getNom() + " assigned to Class " + selectedClass.getNom() + " successfully!");
    }

}

@Override
    public String toString() {
        return "Classe ID: " + id +
                ", Nom: " + nom +
                ", Formateur: " + (formateur != null ? formateur.getNom() : "None") +
                ", Apprenants: " + apprenants.size();
    }
}

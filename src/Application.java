import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static ArrayList<Apprenant> apprenants = new ArrayList<>();
    private static ArrayList<Formateur> formateurs = new ArrayList<>();
    private static ArrayList<classe> classes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Apprenants");
            System.out.println("2. Manage Formateurs");
            System.out.println("3. Manage Classes");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageApprenants(scanner);
                    break;
                case 2:
                    manageFormateurs(scanner);
                    break;
                case 3:
                    manageClasses(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageFormateurs(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Formateurs ---");
            System.out.println("1. Add Formateur");
            System.out.println("2. View Formateur");
            System.out.println("3. Delete Formateur");
            System.out.println("4. Update Formateur");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addFormateur(scanner);
                    break;
                case 2:
                    viewFormateur();
                    break;
                case 3:
                    deleteFormateur(scanner);
                    break;
                case 4:
                    updateFormateur(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addFormateur(Scanner scanner) {
        System.out.println("Enter Formateur ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Formateur Nom:");
        String nom = scanner.nextLine();

        System.out.println("Enter Formateur Prenom:");
        String prenom = scanner.nextLine();

        System.out.println("Enter Formateur Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Formateur Specialite:");
        String specialite = scanner.nextLine();

        double salaire = 0.0;
        while (true) {
            System.out.println("Enter Formateur Salaire:");
            try {
                salaire = Double.parseDouble(scanner.nextLine());
                if (salaire < 0) {
                    System.out.println("Salaire cannot be negative. Please enter a valid amount.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric value for salaire.");
            }
        }

        Formateur formateur = new Formateur(id, nom, prenom, email, specialite, salaire);
        formateurs.add(formateur);

        System.out.println("Formateur added successfully!");
    }

    private static void viewFormateur() {
        if (formateurs.isEmpty()) {
            System.out.println("No formateurs available.");
        } else {
            for (Formateur formateur : formateurs) {
                System.out.println(formateur);
            }
        }
    }

    private static void deleteFormateur(Scanner scanner) {
        System.out.println("Enter the ID of the formateur to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Formateur formateurToDelete = null;
        for (Formateur formateur : formateurs) {
            if (formateur.getId() == id) {
                formateurToDelete = formateur;
                break;
            }
        }
        if (formateurToDelete == null) {
            System.out.println("No formateur found with ID " + id);
            return;
        }
        formateurs.remove(formateurToDelete);
        System.out.println("Formateur deleted successfully!");
    }

    private static void updateFormateur(Scanner scanner) {
        System.out.println("Enter the ID of the formateur to update:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Formateur formateurToUpdate = null;
        for (Formateur formateur : formateurs) {
            if (formateur.getId() == id) {
                formateurToUpdate = formateur;
                break;
            }
        }

        if (formateurToUpdate == null) {
            System.out.println("No formateur found with ID " + id);
            return;
        }

        System.out.println("Enter new specialite (leave blank to keep current):");
        String newSpecialite = scanner.nextLine();
        if (!newSpecialite.isEmpty()) {
            formateurToUpdate.setSpecialite(newSpecialite);
        }

        System.out.println("Enter new salaire (leave blank to keep current):");
        String salaireInput = scanner.nextLine();
        if (!salaireInput.isEmpty()) {
            try {
                double newSalaire = Double.parseDouble(salaireInput);
                formateurToUpdate.setSalaire(newSalaire);
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary. Update aborted.");
            }
        }

        System.out.println("Formateur updated successfully!");
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
                    assignApprenantToClass(scanner);
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

    private static void assignApprenantToClass(Scanner scanner) {
        if (apprenants.isEmpty()) {
            System.out.println("No apprenants available. Add apprenants first.");
            return;
        }
        if (classes.isEmpty()) {
            System.out.println("No classes available. Create a class first.");
            return;
        }

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

    private static void manageApprenants(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Apprenants ---");
            System.out.println("1. Add Apprenant");
            System.out.println("2. View Apprenants");
            System.out.println("3. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addApprenant(scanner);
                    break;
                case 2:
                    viewApprenants();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addApprenant(Scanner scanner) {
        System.out.println("Enter Apprenant ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Apprenant Nom:");
        String nom = scanner.nextLine();

        System.out.println("Enter Apprenant Prenom:");
        String prenom = scanner.nextLine();

        System.out.println("Enter Apprenant Email:");
        String email = scanner.nextLine();

        Apprenant apprenant = new Apprenant(id, nom, prenom, email);
        apprenants.add(apprenant);

        System.out.println("Apprenant added successfully!");
    }

    private static void viewApprenants() {
        if (apprenants.isEmpty()) {
            System.out.println("No apprenants available.");
        } else {
            for (Apprenant apprenant : apprenants) {
                System.out.println(apprenant);
            }
        }
    }
}

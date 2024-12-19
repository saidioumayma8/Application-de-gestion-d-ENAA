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

    private static void manageApprenants(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Apprenants ---");
            System.out.println("1. Add Apprenant");
            System.out.println("2. View Apprenants");
            System.out.println("3. delete Apprenants");
            System.out.println("4. update Apprenants");
            System.out.println("5. Back to Main Menu");

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
                    deleteApprenant(scanner);
                    return;
                case 4:
                    updateApprenant(scanner);
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addApprenant(Scanner scanner) {
        System.out.println("Enter ID:");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Name:");
        String Nom = scanner.nextLine();

        System.out.println("Enter Prenom:");
        String Prenom = scanner.nextLine();

        System.out.println("Enter Email:");
        String Email = scanner.nextLine();

        int n = 0;
        while (true) {
            System.out.println("Enter number of notes (maximum 10):");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n <= 0 || n > 10) {  // Set a reasonable limit on the number of notes
                    System.out.println("Please enter a valid number of notes between 1 and 10.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for notes.");
            }
        }

        int[] notes = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter note " + (i + 1) + ":");
            notes[i] = scanner.nextInt();
        }

        Apprenant apprenant = new Apprenant(ID, Nom, Prenom, Email, notes);
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

    private static void deleteApprenant(Scanner scanner) {
        System.out.println("Enter the ID of the apprenant to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Apprenant apprenantToDelete = null;
        for (Apprenant apprenant : apprenants) {
            if (apprenant.getId() == id) {
                apprenantToDelete = apprenant;
                break;
            }
        }
        if (apprenantToDelete == null) {
            System.out.println("No apprenant found with ID " + id);
            return;
        }
        apprenants.remove(apprenantToDelete);
        System.out.println("Apprenant deleted successfully!");
    }

    private static void updateApprenant(Scanner scanner) {
        if (apprenants.isEmpty()) {
            System.out.println("No apprenants available to update.");
            return;
        }

        System.out.println("Enter the ID of the apprenant to update:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Apprenant apprenantToUpdate = null;

        // Find the apprenant by ID
        for (Apprenant apprenant : apprenants) {
            if (apprenant.getId() == id) {
                apprenantToUpdate = apprenant;
                break;
            }
        }

        if (apprenantToUpdate == null) {
            System.out.println("No apprenant found with ID: " + id);
            return;
        }

        System.out.println("Updating details for: " + apprenantToUpdate);

        // Update the apprenant's name
        System.out.println("Enter new name (leave blank to keep the current name):");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            apprenantToUpdate.setNom(newName);
        }

        // Update the apprenant's prenom
        System.out.println("Enter new prenom (leave blank to keep the current prenom):");
        String newPrenom = scanner.nextLine();
        if (!newPrenom.trim().isEmpty()) {
            apprenantToUpdate.setPrenom(newPrenom);
        }

        // Update the apprenant's email
        System.out.println("Enter new email (leave blank to keep the current email):");
        String newEmail = scanner.nextLine();
        if (!newEmail.trim().isEmpty()) {
            apprenantToUpdate.setEmail(newEmail);
        }

        System.out.println("Apprenant updated successfully!");
    }


    private static void manageFormateurs(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Formateurs ---");
            System.out.println("1. Add Formateur");
            System.out.println("2. View Formateur");
            System.out.println("3. delete Formateur");
            System.out.println("4. update Formateur");
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
                    return;
                case 4:
                    updateFormateur(scanner);
                    return;
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
                salaire = Double.parseDouble(scanner.nextLine()); // Read and parse the input
                if (salaire < 0) {
                    System.out.println("Salaire cannot be negative. Please enter a valid amount.");
                    continue;
                }
                break; // Exit loop if valid
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
            scanner.nextLine(); // Consume newline

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
        System.out.println("Assign Apprenant to Class (to be implemented).");
    }
}

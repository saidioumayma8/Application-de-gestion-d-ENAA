import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static ArrayList<Apprenant> apprenants = new ArrayList<>();
    private static ArrayList<Formateur> formateurs = new ArrayList<>();
    private static ArrayList<classe> classes = new ArrayList<>();


    public static void main(String[] args) {
     Application application=new Application();
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
                    application.manageApprenants(scanner,application);
                    break;
                case 2:
                    application.manageFormateurs(scanner, application);
                    break;
                case 3:
                    application.manageClasses(scanner, application);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void manageFormateurs(Scanner scanner, Application application) {

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
                    application.addFormateur(scanner);
                    break;
                case 2:
                    application.viewFormateur();
                    break;
                case 3:
                    application.deleteFormateur(scanner);
                    break;
                case 4:
                    application.updateFormateur(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private  void addFormateur(Scanner scanner) {
        System.out.println("Enter Formateur ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

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

    private  void viewFormateur() {
        if (formateurs.isEmpty()) {
            System.out.println("No formateurs available.");
        } else {
            for (Formateur formateur : formateurs) {
                System.out.println(formateur);
            }
        }
    }

    private  void deleteFormateur(Scanner scanner) {
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

    private  void updateFormateur(Scanner scanner) {
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

        System.out.println("Enter new specialite :");
        String newSpecialite = scanner.nextLine();
        if (!newSpecialite.isEmpty()) {
            formateurToUpdate.setSpecialite(newSpecialite);
        }

        System.out.println("Enter new salaire:");
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

    private  void manageClasses(Scanner scanner, Application application) {
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
                    application.createClass(scanner);
                    break;
                case 2:
                    application.viewClasses();
                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private  void createClass(Scanner scanner) {
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

    private  void viewClasses() {
        if (classes.isEmpty()) {
            System.out.println("No classes available.");
            return;
        }

        for (classe classe : classes) {
            System.out.println(classe);
        }
    }

    private void manageApprenants(Scanner scanner,Application application) {

        while (true) {
            System.out.println("\n--- Manage Apprenants ---");
            System.out.println("1. Add Apprenant");
            System.out.println("2. View Apprenants");
            System.out.println("3. Delete Apprenant");
            System.out.println("4. Update Apprenants");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    application.addApprenant(scanner);
                    break;
                case 2:
                    application.viewApprenants();
                    break;
                case 3:
                    application.deleteApprenant(scanner);
                    return;
                case 4:
                    application.updateApprenant(scanner);
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addApprenant(Scanner scanner) {
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

    private  void viewApprenants() {
        if (apprenants.isEmpty()) {
            System.out.println("No apprenants available.");
        } else {
            for (Apprenant apprenant : apprenants) {
                System.out.println(apprenant);
            }
        }
    }

    private  void deleteApprenant(Scanner scanner) {
        System.out.println("Enter the ID of the Apprenant to delete:");
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

    private void updateApprenant(Scanner scanner) {
        System.out.println("Enter the ID of the Apprenant to update:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Apprenant apprenantToUpdate = null;
        for (Apprenant apprenant : apprenants) {
            if (apprenant.getId() == id) {
                apprenantToUpdate = apprenant;
                break;
            }
        }

        if (apprenantToUpdate == null) {
            System.out.println("No apprenant found with ID " + id);
            return;
        }


        System.out.println("Enter new Nom (leave blank to keep current):");
        String newNom = scanner.nextLine();
        if (!newNom.isEmpty()) {
            apprenantToUpdate.setNom(newNom);
        }

        System.out.println("Enter new Prenom (leave blank to keep current):");
        String newPrenom = scanner.nextLine();
        if (!newPrenom.isEmpty()) {
            apprenantToUpdate.setPrenom(newPrenom);
        }

        System.out.println("Enter new Email (leave blank to keep current):");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            apprenantToUpdate.setEmail(newEmail);
        }

        System.out.println("Apprenant updated successfully!");
    }

}

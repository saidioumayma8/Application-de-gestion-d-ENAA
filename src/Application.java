import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    static ArrayList<Apprenant> apprenants = new ArrayList<>(); // Global list of Apprenants

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Apprenants");
            System.out.println("2. Manage Formateurs");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    manageApprenants(scanner);
                    break;
                case 2:
                    manageFormateurs();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void manageApprenants(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Manage Apprenants ---");
            System.out.println("1. Add Apprenant");
            System.out.println("2. View Apprenants");
            System.out.println("3. Delete Apprenant");
            System.out.println("4. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addApprenant(scanner);
                    break;
                case 2:
                    viewApprenant();
                    break;
                case 3:
                    deleteApprenant(scanner);
                    break;
                case 4:
                    return; // Go back to main menu
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addApprenant(Scanner scanner) {
        System.out.println("Enter ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter Nom:");
        String nom = scanner.nextLine();

        System.out.println("Enter Prenom:");
        String prenom = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        System.out.println("Enter notes (comma-separated):");
        String notesStr = scanner.nextLine();
        String[] notesArray = notesStr.split(",");
        int[] notes = new int[notesArray.length];
        for (int i = 0; i < notesArray.length; i++) {
            notes[i] = Integer.parseInt(notesArray[i].trim());
        }

        Apprenant apprenant = new Apprenant(id, nom, prenom, email, notes);
        apprenants.add(apprenant);
        System.out.println("Apprenant added successfully.");
    }

    public static void viewApprenant() {
        if (apprenants.isEmpty()) {
            System.out.println("No Apprenants available.");
        } else {
            for (Apprenant apprenant : apprenants) {
                System.out.println("ID: " + apprenant.ID);
                System.out.println("Nom: " + apprenant.Nom);
                System.out.println("Prenom: " + apprenant.Prenom);
                System.out.println("Email: " + apprenant.Email);
                System.out.print("Notes: ");
                for (int note : apprenant.nots) {
                    System.out.print(note + " ");
                }
                System.out.println("\n--------------------------");
            }
        }
    }

    public static void deleteApprenant(Scanner scanner) {
        System.out.println("Enter the ID of the Apprenant to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        Apprenant apprenantToDelete = null;
        for (Apprenant apprenant : apprenants) {
            if (apprenant.ID == id) {
                apprenantToDelete = apprenant;
                break;
            }
        }

        if (apprenantToDelete == null) {
            System.out.println("Apprenant not found!");
        } else {
            apprenants.remove(apprenantToDelete);
            System.out.println("Apprenant deleted successfully!");
        }
    }

    public static void manageFormateurs() {
        System.out.println("Managing Formateurs... (not implemented yet)");
    }

    abstract static class Personne {
        int ID;
        String Nom;
        String Prenom;
        String Email;

        public Personne(int ID, String Nom, String Prenom, String Email) {
            this.ID = ID;
            this.Nom = Nom;
            this.Prenom = Prenom;
            this.Email = Email;
        }

        public abstract void reference();
    }

    static class Apprenant extends Personne {
        int[] nots;

        public Apprenant(int ID, String Nom, String Prenom, String Email, int[] notes) {
            super(ID, Nom, Prenom, Email);
            this.nots = notes;
        }

        @Override
        public void reference() {
            System.out.println("Apprenant");
        }
    }

    static class Formateur extends Personne {
        String specialite;
        double salaire;

        public Formateur(int ID, String Nom, String Prenom, String Email, double salaire, String specialite) {
            super(ID, Nom, Prenom, Email);
            this.salaire = salaire;
            this.specialite = specialite;
        }

        @Override
        public void reference() {
            System.out.println("Formateur");
        }
    }
}

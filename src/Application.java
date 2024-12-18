import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static ArrayList<Apprenant> apprenants = new ArrayList<>();
    private static ArrayList<Formateur> formateurs = new ArrayList<>();
    private static ArrayList<Classe> classes = new ArrayList<>();

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
        System.out.println("Enter ID:");
        int ID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Name:");
        String Nom = scanner.nextLine();

        System.out.println("Enter Prenom:");
        String Prenom = scanner.nextLine();

        System.out.println("Enter Email:");
        String Email = scanner.nextLine();

        System.out.println("Enter number of notes:");
        int n = scanner.nextInt();
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

    private static void manageFormateurs(Scanner scanner) {
        System.out.println("Manage Formateurs (to be implemented).");
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
        String name = scanner.nextLine();

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

        Formateur formateur = formateurs.get(formateurIndex);
        Classe classe = new Classe(id, name, formateur);
        classes.add(classe);

        System.out.println("Class created successfully!");
    }

    private static void viewClasses() {
        if (classes.isEmpty()) {
            System.out.println("No classes available.");
        } else {
            for (Classe classe : classes) {
                System.out.println("ID: " + classe.getId() +
                        ", Name: " + classe.getName() +
                        ", Formateur: " + classe.getFormateur().getNom());
            }
        }
    }

    private static void assignApprenantToClass() {
        System.out.println("Assign Apprenant to Class (to be implemented).");
    }
}

import java.util.Scanner;

public class Apprenant {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int[] notes; // or ArrayList<Double>, depending on your implementation


    public Apprenant(int id, String nom, String prenom, String email, int[] notes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.notes = notes;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int[] getNotes() {
        return notes;
    }

    public void setNotes(int[] notes) {
        this.notes = notes;
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



    @Override
    public String toString() {
        return "Apprenant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

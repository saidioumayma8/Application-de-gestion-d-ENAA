import java.util.Scanner;

public class Formateur extends Personne {
    private String specialite;
    private double salaire;
    private classe classe;


    public Formateur(int id, String nom, String prenom, String email, String specialite, double salaire) {
        super(id, nom, prenom, email);
        this.specialite = specialite;
        this.salaire = salaire;
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
        if (salaire < 0) {
            throw new IllegalArgumentException("Le salaire ne peut pas être négatif.");
        }
        this.salaire = salaire;
    }


    public classe getClasse() {
        return classe;
    }


    public void setClasse(classe classe) {
        this.classe = classe;
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


    @Override
    public String toString() {
        return super.toString() + ", Specialité: " + specialite + ", Salaire: " + salaire;
    }
}

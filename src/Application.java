import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Declare and initialize the scanner

        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Manage Apprenants");
        System.out.println("2. Manage Formateurs");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        switch (choice) {
            case 1:
                manageApprenants();
                break;
            case 2:
                manageFormateurs();
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0); // Exit the program
                break;
            default:
                System.out.println("Invalid choice. Try again");
        }

        scanner.close(); // Close the scanner
    }

    public static void manageApprenants() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add Appranent");
        System.out.println("view Appranent");
        System.out.println("Update Appranent");
        System.out.println("Delete Appranent");
        System.out.println("back to main menu");

        int choice = scanner.nextInt();
        scanner.nextInt();

        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }
    public static void addApprenant(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre ID");
        int ID = scanner.nextInt();
        scanner.nextInt();

        System.out.println("Entre Nom");
        int ID = scanner.nextInt();
        scanner.nextInt();

        System.out.println("Entre Prenom");
        int ID = scanner.nextInt();
        scanner.nextInt();

        System.out.println("Entre Email");
        int ID = scanner.nextInt();
        scanner.nextInt();

        System.out.println("Entre notes");

        scanner.nextInt();
    }

    public static void manageFormateurs() {
        System.out.println("Managing Formateurs...");
    }

    abstract class Personne {
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

    class Apprenant extends Personne {
        int nots[];

        public Apprenant(int ID, String Nom, String Prenom, String Email, int[] notes) {
            super(ID, Nom, Prenom, Email);
            this.nots = notes;
        }

        @Override
        public void reference() {
            System.out.println("Apprenant");
        }
    }

    class Formateur extends Personne {
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

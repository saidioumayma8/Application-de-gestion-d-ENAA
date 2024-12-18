import java.util.ArrayList;
import java.util.Scanner;

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
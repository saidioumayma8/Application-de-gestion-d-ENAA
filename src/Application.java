//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
        int Id;
        String nom;
        String prenom;
        String email;

    }

    abstract class Personne{
        public abstract void reference();

    }
    class Apprenant extends Personne {
        public void reference(){

        }
        int nots[];

    }
    class Formateur extends Personne{
        public void reference(){

        }
        String specialite;
        double salaire;

    }

}
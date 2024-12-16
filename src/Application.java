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
        int ID
        String Nom;
        String Prenom;
        String Email;


        public Personne(int ID, String Nom, String Prenom, String Email){
            this.ID = ID;
            this.Nom = Nom;
            this.Prenom = Prenom;
            this.Email = Email;

        }
        public abstract void reference();

    }
    class Apprenant extends Personne {
        public Apprenant(int ID, String Nom, String Prenom, String Email,int nots[]){
            this.ID = ID;
            this.Nom = Nom;
            this.Prenom = Prenom;
            this.Email = Email;
        }
        public void reference(){
                System.out.println("Apprenant");
        }


    }
    class Formateur extends Personne{
        public void reference(){

        }
        String specialite;
        double salaire;

    }

}
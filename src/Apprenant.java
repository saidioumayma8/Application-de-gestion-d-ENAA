import java.util.ArrayList;
import java.util.Scanner;

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


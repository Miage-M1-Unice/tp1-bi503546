package fr.miage.master1.tp1.exo2;
import java.io.FileNotFoundException;
import java.util.Scanner;


    public class SeLit {
        void lecture(Scanner source) {

            while(source.hasNextLine()) {
                String s = source.nextLine();
                System.out.println("LU:" +s);
                        // A modifier
            }
        }

        static public void main(String[] args) throws FileNotFoundException {
            java.util.Scanner lecteur ;
            java.io.File fichier = new java.io.File(args[0]);
            lecteur = new java.util.Scanner(fichier);
            SeLit s = new SeLit();
            s.lecture(lecteur);
        }
    }


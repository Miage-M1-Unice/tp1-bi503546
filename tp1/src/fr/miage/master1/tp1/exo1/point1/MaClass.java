package fr.miage.master1.tp1.exo1.point1;
import java.io.*;

public class MaClass {

    public void recuperer(){
        File monRep = new File(".");
        String liste[] = monRep.list();

        if (liste != null) {
            for (int i = 0; i < liste.length; i++) {
                System.out.println(liste[i]);
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
    }
    public static void main(String[]args){

        MaClass m = new MaClass();
        m.recuperer();
           }
}

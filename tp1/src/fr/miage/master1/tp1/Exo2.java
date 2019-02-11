package fr.miage.master1.tp1;


import java.io.File;

public class Exo2 {

    public void recuperer(File file) {


        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) {
                        recuperer(files[i]);
                    }
                    else
                        System.out.println(files[i]);
                }
            }
        }

    }
    public static void main(String[]args){

        Exo2 m = new Exo2();
        m.recuperer(new File("."));
    }
}
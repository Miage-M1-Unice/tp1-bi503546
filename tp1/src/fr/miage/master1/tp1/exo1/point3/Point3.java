package fr.miage.master1.tp1.exo1.point3;

import java.io.File;
import java.io.FileFilter;

public class Point3{



        FileFilter filter = new FileFilter() {

            private String extension;
            public boolean accept(File f) {
                return f.isFile() && f.getName().contains(extension) || f.isDirectory();
            }

    };

    public void affiche(File file, String extension) {

        if (!file.isDirectory())
            System.out.println(file);
        else
            for (File f : file.listFiles(filter))
                affiche(f, extension);

    }


    public static void main(String[] args) {

        File file = new File(".");
        Point3 p = new Point3();
        p.affiche(file, "java");


    }
}
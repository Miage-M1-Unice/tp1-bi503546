package fr.miage.master1.tp1.exo1.PointC;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
public class Point1C {

    public static void main(String[] args) throws IOException {

        File f = new File("."); // current directory

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".java")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        File[] files = f.listFiles(textFilter);
        for(File file :files)

            {
                if (file.isDirectory()) {
                    System.out.print("directory:");
                } else {
                    System.out.print("file:");
                }
                System.out.println(file);
            }

        }

    }
package fr.miage.master1.tp3;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureClassLoader;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class MyClassLoader extends SecureClassLoader {
    private ArrayList<File> path = null;

    public MyClassLoader(ArrayList<File> p) {
        this.path = p;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = new byte[0];
        try {
            b = loadClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException, IOException {
        File f = new File(name);
        DataInputStream input = new DataInputStream(new FileInputStream(f));
        byte[] content = new byte[(int)f.length()];
        input.readFully(content);
        //System.out.println(content);
        return content;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ArrayList<File> al = new ArrayList<File>();
        al.add(new File("File:///C:/Users/imen/Desktop/tp/tp1-bi503546/tp1/out/production/tp1/fr.miage.master1.tp2.AnalyseurDeClass"));
        MyClassLoader myCL = new MyClassLoader(al);
        //myCL.loadClassData("fr.miage.master1.tp2.AnalyseurDeClass");
       try {

            myCL.loadClass("fr.miage.master1.tp2.AnalyseurDeClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
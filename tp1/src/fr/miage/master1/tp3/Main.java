package fr.miage.master1.tp3;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
public class Main {

        public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {

            URL[] urls = {new URL("file:///D:/cours/L3/POO/Moy")};
            System.out.println(urls[0]);
            URLClassLoader ucl = new URLClassLoader(urls);
            Class c = ucl.loadClass("moy.Moyenne");
            System.out.println(c);
        }

}

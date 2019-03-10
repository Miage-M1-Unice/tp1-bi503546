package fr.miage.master1.tp3;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
public class Main {

        public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
            URL[] urls = {new URL("file://C:\\Users\\imen\\Desktop\\tp1\\tp1-bi503546\\tp1")};
            URLClassLoader ucl = new URLClassLoader(urls);
            ucl.loadClass("fr.miage.master1.tp2.AnalyseurDeClasse");
            System.out.println(ucl);
        }

}

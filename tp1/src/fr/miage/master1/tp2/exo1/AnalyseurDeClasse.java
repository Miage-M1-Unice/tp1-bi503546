package fr.miage.master1.tp2.exo1;


import java.lang.reflect.*;
import java.io.*;
import java.util.Arrays;

/**
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 * @version 1.00 23 Mars 2001
 */


public class AnalyseurDeClasse {



    public static void analyseClasse(String nomClasse) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = Class.forName(nomClasse);// CODE A ECRIRE !
        System.out.println();
        afficheEnTeteClasse(cl);
        System.out.println();
        System.out.print("// Champs\n");
        afficheAttributs(cl);

        System.out.println();
        System.out.print("// Constructeurs \n");
        afficheConstructeurs(cl);
        System.out.println();

        System.out.print("// Methodes \n");
        afficheMethodes(cl);
        System.out.println();
        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /**
     * Retourne la classe dont le nom est passé en paramètre
     */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse).getSimpleName().getClass();
    }

    /**
     * Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {"
     */
    public static void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        System.out.print(Modifier.toString(cl.getModifiers()) + " class ");
        System.out.print(cl.getName());

        // Récupération de la superclasse si elle existe (null si cl est le type Object)




        // On ecrit le "extends " que si la superclasse est non nulle et
        // différente de Object
        Class supercl = cl.getSuperclass();
        System.out.print(" extends "+ supercl.getName());

        // Affichage des interfaces que la classe implemente
        Class[] interfaces = cl.getInterfaces();
        for(int i = 0; i< interfaces.length; i++)
            System.out.print(" implements "+ interfaces[i].getName());


        // Enfin, l'accolade ouvrante !
        System.out.print(" {\n");
    }

    public static void afficheAttributs(Class cl)  {
        Field[] declaredFields = cl.getDeclaredFields();
        for(int i = 0; i < declaredFields.length; i++){
            System.out.print(Modifier.toString( declaredFields[i].getModifiers()) + " ");
            System.out.println(declaredFields[i].getGenericType() +" "+ declaredFields[i].getName() +";");
        }
    }

    public static void afficheConstructeurs(Class cl){

        Constructor[] cons1 = cl.getConstructors();
        for(int i = 0; i < cons1.length; i++)
            System.out.println("  "+cons1[i] +";");


    }


    public static void afficheMethodes(Class cl) {

        Method[] methods = cl.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.print(Modifier.toString(methods[i].getModifiers()) + " ");
            System.out.print(methods[i].getGenericReturnType() + " "+  methods[i].getName() + "(");
            Parameter params[] = methods[i].getParameters();
            for(Parameter p : params) {
                System.out.print(p.getType().getName() + ",");
            }
            System.out.println(")");
        }
    }
        public static String litChaineAuClavier () throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        }


    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IOException, IllegalAccessException, InvocationTargetException, InstantiationException {
        boolean ok = false;

        while (!ok) {
            //System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
            String nomClasse = "java.awt.Point";

            analyseClasse(nomClasse);

            ok = true;
        }
    }
}

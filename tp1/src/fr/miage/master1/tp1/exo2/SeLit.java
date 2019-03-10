package fr.miage.master1.tp1.exo2;
import java.io.*;
import java.util.Scanner;


public class SeLit {
    void lecture(Scanner source) {

        while (source.hasNextLine()) {
            String s = source.nextLine();
            System.out.println(s);
        }
    }

    void ecriture(String nomFichier) throws IOException {

        File file = new File("./" + nomFichier);
        file.createNewFile();

        FileOutputStream fileOutputStream=null;
        PrintStream printStream=null;
        try {
            fileOutputStream=new FileOutputStream(file);
            printStream=new PrintStream(fileOutputStream);

            //Print char value
            printStream.print('A');

            //Print long value
            printStream.print(100L);

            //Print double value
            printStream.print(45.451);

           //Print newline
            printStream.println();

            //Print String
            printStream.println("This an example of the PrintStream class");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
                if(printStream!=null){
                    printStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static public void main(String[] args) throws FileNotFoundException {

        SeLit s = new SeLit();
        File file = new File("./src/fr/miage/master1/tp1/exo2/Selit.java");
        try {
            Scanner scanner = new Scanner(file);
            s.lecture(scanner);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try{
            s.ecriture("output.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
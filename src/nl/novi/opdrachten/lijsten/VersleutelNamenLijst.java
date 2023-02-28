package nl.novi.opdrachten.lijsten;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VersleutelNamenLijst {

    /**
     * Bijgevoegd is verzetsleden.txt
     * Maak een programma dat verzetsleden.txt uitleest.
     * Versleutel de namen op dezelfde manier als in GeheimeCode.java
     * En sla de versleutelde namen op in secret.txt
     *
     */


    // Reads strings from textfile and returns list of strings
    private static List<String> readTextFile(String path) {
        List<String> myList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str = "";
            while ((str = br.readLine()) != null) {
                myList.add(str);
            }
        } catch (Exception e) {
            System.out.println("An error occured while reading the file");
        }
        return myList;
    }

//    private static void writeTextFile(List<String> myList, String path) throws IOException {
//        BufferedWriter br = new BufferedWriter(new FileWriter(path));
//        try {
//            for (String str: myList
//                 ) {
//                br.write(str + System.lineSeparator());
//            }
//            br.close();
//        } catch (Exception e){
//            System.out.println("An error occured while writing the file");
//        }
//    }

    private static void writeTextFile(List<String> myList, String path) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(path));
        for (String str: myList) {
            br.write(str + System.lineSeparator());
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        GeheimeCode gc = new GeheimeCode();


        String sourcePath = ".\\src\\nl\\novi\\opdrachten\\lijsten\\verzetsleden.txt";
        List<String> codedFile = gc.codeNameList(readTextFile(sourcePath));
        writeTextFile(codedFile, ".\\src\\nl\\novi\\opdrachten\\lijsten\\secret.txt");
    }


}

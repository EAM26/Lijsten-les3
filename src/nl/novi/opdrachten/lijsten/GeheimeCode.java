package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeheimeCode {

    // Check for double names. If not, then add.
    private static List<String> addMembers(List<String> members, String name) {
        if(!members.contains(name)) {
            members.add(name);
        }
        return members;
    }

    // Takes a name list and codes it into series of numbers
    public static List<String> codeNameList(List<String> sourceList){
        List<String> targetList = new ArrayList<>();
        for (String s : sourceList) {
            String codedName = codeSingleName(s);
            targetList.add(codedName);
        }
        return targetList;
    }

    // main method for decoding names
    public static List<String> deCodeNameList(List<String> sourceList){
        List<String> targetList = new ArrayList<>();
        for (int i = 0; i < sourceList.size(); i++) {
            String deCodedName = deCodeSingleName(sourceList.get(i));
            targetList.add(deCodedName);
        }
        return targetList;
    }



    // code String name into string number a=1, A=101
    private static String codeSingleName(String name) {
        String codedName = "";
        //loop through letters to get numValue
        char[] lettersArray = name.toCharArray();
        for (int i = 0; i < lettersArray.length; i++) {
            String numLetter = getNumberValue(lettersArray[i]);
            // Reverses every second letter, first position (0) included
            if(i%2==0) {
                numLetter = reverseString(numLetter);
            }
            codedName += (numLetter);
            // Add dash except to last number
            if(i < name.length()-1) {
                codedName += "-";
            }
        }
        return codedName;
    }


    // Turns char into a string-number: a=1 A=101
    public static String getNumberValue(char c) {
        int tempNum = c;
        if(tempNum >= 97) {
            tempNum -= 96;
        } else {
            tempNum += 36;
        }
        return Integer.toString(tempNum);
    }

    // Takes single coded name and returns decoded name
    private static String deCodeSingleName(String codedName) {
        ArrayList<String> newNameAsList = new ArrayList<>();

        // Splits name in array of numbers and loops
        ArrayList<String> nameAsList = new ArrayList<>(Arrays.asList(codedName.split("-")));
        for (int i = 0; i < nameAsList.size(); i++) {
            String oldNum = nameAsList.get(i);

            // Reverses numbers on even position
            if(i % 2 == 0) {
                oldNum = reverseString(oldNum);
            }
            newNameAsList.add(getLetter(oldNum));
        }
        return String.join("", newNameAsList);

    }

    // Gets corresponding letter from number value
    public static String getLetter(String numString) {
        int tempNum = Integer.parseInt(numString);
        if(tempNum >= 101) {
            tempNum -= 36;
        } else {
            tempNum += 96;
        }
        char letter = (char) tempNum;
        return String.valueOf(letter);
    }

    // Reverses the order of numbers: 911 -> 119
    private static String reverseString(String sourceString) {
        char[] letters = sourceString.toCharArray();
        String targetString = "";
        for (int i = sourceString.length()-1; i >= 0; i--) {

            targetString += letters[i];
        }

        return targetString;
    }
    public static void main(String[] secret) {

        List<String> laResistanceMembers = new ArrayList<>();

        laResistanceMembers = addMembers(laResistanceMembers, "Arie");
        laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Piet");
        laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");


        // coded list
        List<String> codedList = (codeNameList(laResistanceMembers));
        System.out.println(codedList);

        // decoded list
        List<String> decodedList = deCodeNameList(codedList);
        System.out.println(decodedList);


        /*
        Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
         er alleen unieke namen in voor mogen komen.
         */

        /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
         */


        /*
        Opdracht 3:
        Schrijf een methode die de versleutelde lijst kan omzetten naar de ontsleutelde lijst.
         */
    }



}

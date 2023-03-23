package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath = "text.txt";
        String textData = null;
        try {
            textData = readFileToStringLowerCase(filePath);
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
            return;
        }
        System.out.println("Text:");
        System.out.println(textData);

        HashMap<Character, Integer> frequency = frequencyFinder(textData);

        System.out.println("--------------------");
        System.out.println("Letter Frequency(Excluding non existing):");
        printFrequencyHashMap(frequency);
        System.out.println("--------------------");
        System.out.println("This text uses "+getUsedLetterCount(frequency)+" of 26 English alphabet letters");
        return;
    }
    //prints out letter frequency HashMap
    public static void printFrequencyHashMap(HashMap<Character, Integer> frequencyHashMap){
        for (HashMap.Entry<Character, Integer> entry : frequencyHashMap.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        return;
    }
    //returns count of used unique letters
    public static Integer getUsedLetterCount(HashMap<Character, Integer> frequencyHashMap){
        Integer count = 0;
        for (HashMap.Entry<Character, Integer> entry : frequencyHashMap.entrySet()){
            count += 1;
        }
        return count;
    }
    //gets frequency of letters returns HashMap with frequency
    public static HashMap<Character, Integer> frequencyFinder(String testString){
        HashMap<Character, Integer> frequencyHashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < testString.length(); i++) {
            if(frequencyHashMap.containsKey(testString.charAt(i))) {
                frequencyHashMap.put(testString.charAt(i), frequencyHashMap.get(testString.charAt(i)) + 1);
            }
            else if((testString.charAt(i) >= 'a' && testString.charAt(i) <= 'z')) {
                frequencyHashMap.put(testString.charAt(i), 1);
            }
        }
        return frequencyHashMap;
    }
    //reads file and returns string with content
    public static String readFileToStringLowerCase(String filePathTemp) throws FileNotFoundException {
        File myObj = new File(filePathTemp);
        String textData = null;
        Scanner myReader = new Scanner(myObj);
        textData = myReader.useDelimiter("\\Z").next().toLowerCase();
        myReader.close();
        return textData;
    }
}